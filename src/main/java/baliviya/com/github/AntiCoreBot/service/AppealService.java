package baliviya.com.github.AntiCoreBot.service;

import baliviya.com.github.AntiCoreBot.enums.Language;
import baliviya.com.github.AntiCoreBot.model.custom.AppealType;
import baliviya.com.github.AntiCoreBot.model.custom.Employee;
import baliviya.com.github.AntiCoreBot.model.custom.Task;
import baliviya.com.github.AntiCoreBot.model.standart.User;
import baliviya.com.github.AntiCoreBot.repository.*;
import baliviya.com.github.AntiCoreBot.util.Const;
import baliviya.com.github.AntiCoreBot.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AppealService {

    private XSSFWorkbook        workbook        = new XSSFWorkbook();
    private XSSFCellStyle       style           = workbook.createCellStyle();
    private Sheet               sheet;
    private DefaultAbsSender    bot;
    private TaskRepo            taskRepo        = TelegramBotRepositoryProvider.getTaskRepo();
    private EmployeeRepo        employeeRepo    = TelegramBotRepositoryProvider.getEmployeeRepo();
    private UsersRepo           usersRepo       = TelegramBotRepositoryProvider.getUserRepo();
    private AppealTypeRepo      appealTypeRepo  = TelegramBotRepositoryProvider.getAppealTypeRepo();
    private FileRepo            fileRepo        = TelegramBotRepositoryProvider.getFileRepo();
    private PropertiesRepo      propertiesRepo  = TelegramBotRepositoryProvider.getPropertiesRepo();
    private TaskArchiveRepo     taskArchiveRepo = TelegramBotRepositoryProvider.getTaskArchiveRepo();
    private Language            currentLanguage = Language.ru;

    public  void            sendReports(long chatId, DefaultAbsSender bot, Date dateBegin, Date dateEnd, int preview) {
        currentLanguage = LanguageService.getLanguage(chatId);
        this.bot        = bot;
        try {
            sendReport(chatId, dateBegin, dateEnd, preview);
        } catch (Exception e) {
            log.error("Can't create/send report", e);
            try {
                bot.execute(new SendMessage(chatId, "\uD83E\uDD2A Ошибка при создании отчета"));
            } catch (TelegramApiException ex) {
                log.error("Can't send message", ex);
            }
        }
    }

    private void            sendReport(long chatId, Date dateBegin, Date dateEnd, int previewId)                        throws IOException, TelegramApiException {
        sheet                       = workbook.createSheet("Отчет по обращениям");
        List<Task> tasks            = taskRepo.findAllByDateBeginAfterAndDateBeginBefore(dateBegin, dateEnd);
        int done                    = taskRepo.countAllByDateBeginAfterAndDateBeginBeforeAndIdStatus(dateBegin, dateEnd, 1);
        int doing                   = taskRepo.countAllByDateBeginAfterAndDateBeginBeforeAndIdStatus(dateBegin, dateEnd, 3);
        int total                   = done + doing;
        BorderStyle thin            = BorderStyle.THIN;
        short black                 = IndexedColors.BLACK.getIndex();
        XSSFCellStyle styleTitle    = setStyle(workbook, thin, black, style);
        int rowIndexForTitle        = 0;
        int rowIndex                = 4;
        createTitle(styleTitle, rowIndexForTitle, Arrays.asList("Выполнено;В процессе;Общее".split(Const.SPLIT)));
        sheet.createRow(1);
        addCellValue(1, 0, String.valueOf(done), style);
        addCellValue(1, 1, String.valueOf(doing), style);
        addCellValue(1, 2, String.valueOf(total), style);
        createTitle(styleTitle, rowIndex, Arrays.asList("№;Заявитель;Категория;Текст;Дата и Время;Ответственный;Статус;Ссылка на местоположение;Ссылка на Фото;Ответ исполнителя".split(Const.SPLIT)));
        List<Employee> employees        = employeeRepo.findAll();
        List<User> users                = usersRepo.findAll();
        List<AppealType> types          = appealTypeRepo.findAll();
        List<List<String>> info         = tasks.stream().map(task -> {
            List<String> list           = new ArrayList<>();
            List<Employee> employeeList = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getHandling() == task.getHandling()) employeeList.add(employee);
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (employeeList != null || employeeList.size() != 0) {
                for (Employee employee : employeeList) {
                    User employeeUser   = users.stream().filter(user -> employee.getEmployeeId() == user.getChatId()).findAny().orElse(null);
                    stringBuilder.append(employeeUser.getFullName()).append(",");
                }
            }
            list.add(String.valueOf(task.getId()));
            User people                 = users.stream().filter(user -> task.getPeopleId() == user.getChatId()).findAny().orElse(null);
            list.add(people.getFullName() + " (" + people.getPhone() + ")");
            AppealType handlingType     = types.stream().filter(appealType -> task.getHandling() == appealType.getId()).findAny().orElse(null);
            list.add(handlingType.getName());
            list.add(task.getTaskText());
            list.add(DateUtil.getDayDate(task.getDateBegin()));
            list.add(stringBuilder.toString());
            if (task.getIdStatus() == 1) {
                list.add("Выполнено");
            } else if (task.getIdStatus() == 2) {
                list.add("Невыполнено");
            }  else {
                list.add("В процессе");
            }
            fileRepo.findByIdTask(task.getId()).ifPresent(file -> {
                String[] split = file.getLocation().split(Const.SPLIT);
                list.add("https://www.google.com/maps?q=" + split[0] + "," + split[1] + "&ll=" + split[0] + "," + split[1] + "&z=16");
            });
            fileRepo.findByIdTask(task.getId()).ifPresent(file -> {
                list.add("https://api.telegram.org/file/bot" + propertiesRepo.findById(Const.BOT_TOKEN).get().getValue() + "/" + uploadFile(file.getImg()));
            });
            list.add(taskArchiveRepo.findByTaskId(task.getId()).map(taskArchive -> taskArchive.getText()).orElse(" "));
            return list;
        }).collect(Collectors.toList());
        addInfo(info, rowIndex);
        sendFile(chatId, dateBegin, dateEnd);
    }

    private void            addInfo(List<List<String>> reports, int rowIndex) {
        int cellIndex;
        for (List<String> rE : reports) {
            sheet.createRow(++rowIndex);
            insertToRow(rowIndex, rE, style);
//            insertToRowURL(rowIndex, rE, hLinkStyle);
        }
        cellIndex = 0;
        sheet.autoSizeColumn(cellIndex++);
        sheet.setColumnWidth(cellIndex++, 4000);
        sheet.setColumnWidth(cellIndex++, 7000);
        sheet.autoSizeColumn(cellIndex++);
        sheet.autoSizeColumn(cellIndex++);
        sheet.setColumnWidth(cellIndex++, 4000);
        sheet.setColumnWidth(cellIndex++, 13200);
        sheet.setColumnWidth(cellIndex++, 23500);
        sheet.setColumnWidth(cellIndex++, 4000);
    }

    private void            createTitle(XSSFCellStyle styleTitle, int rowIndex, List<String> title) {
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Arial");
        font.setItalic(false);
        styleTitle.setFont(font);
        sheet.createRow(rowIndex);
        insertToRow(rowIndex, title, styleTitle);
    }

    private XSSFCellStyle   setStyle(XSSFWorkbook wb, BorderStyle thin, short black, XSSFCellStyle style) {
        style.setWrapText(true);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderTop(thin);
        style.setBorderBottom(thin);
        style.setBorderRight(thin);
        style.setBorderLeft(thin);
        style.setTopBorderColor(black);
        style.setRightBorderColor(black);
        style.setBottomBorderColor(black);
        style.setLeftBorderColor(black);
        BorderStyle tittle          = BorderStyle.MEDIUM;
        XSSFCellStyle styleTitle    = wb.createCellStyle();
        styleTitle.setWrapText(true);
        styleTitle.setAlignment(HorizontalAlignment.CENTER);
        styleTitle.setVerticalAlignment(VerticalAlignment.CENTER);
        styleTitle.setBorderTop(tittle);
        styleTitle.setBorderBottom(tittle);
        styleTitle.setBorderRight(tittle);
        styleTitle.setBorderLeft(tittle);
        styleTitle.setTopBorderColor(black);
        styleTitle.setRightBorderColor(black);
        styleTitle.setBottomBorderColor(black);
        styleTitle.setLeftBorderColor(black);
        style.setFillForegroundColor(new XSSFColor(new Color(0, 52, 94)));
        return styleTitle;
    }

    private void            insertToRow(int row, List<String> cellValues, CellStyle cellStyle) {
        int cellIndex = 0;
        for (String cellValue : cellValues) {
            addCellValue(row, cellIndex++, cellValue, cellStyle);
        }
    }

    private void            addCellValue(int rowIndex, int cellIndex, String cellValue, CellStyle cellStyle) {
        sheet.getRow(rowIndex).createCell(cellIndex).setCellValue(getString(cellValue));
        sheet.getRow(rowIndex).getCell(cellIndex).setCellStyle(cellStyle);
    }

    private String          getString(String nullable) {
        if (nullable == null) return "";
        return nullable;
    }

    private void            sendFile(long chatId, Date dateBegin, Date dateEnd)                   throws IOException, TelegramApiException {
        String fileName = "Отчет обращении за: " + DateUtil.getDayDate(dateBegin) + " - " + DateUtil.getDayDate(dateEnd) + ".xlsx";
        String path     = "C:\\test\\" + fileName;
        path            += new Date().getTime();
        try (FileOutputStream tables = new FileOutputStream(path)) {
            workbook.write(tables);
        } catch (IOException e) {
            log.error("error read file to AppealService.sendFile() ", e);
        }
        sendFile(chatId, fileName, path);
    }

    private void            sendFile(long chatId, String fileName, String path)                   throws IOException, TelegramApiException {
        File file = new File(path);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            bot.execute(new SendDocument().setChatId(chatId).setDocument(fileName, fileInputStream));
        }
        file.delete();
    }

    private String          uploadFile(String fileId) {
        Objects.requireNonNull(fileId);
        GetFile getFile = new GetFile();
        getFile.setFileId(fileId);
        try {
            org.telegram.telegrambots.meta.api.objects.File file = bot.execute(getFile);
            return file.getFilePath();
        } catch (TelegramApiException e) {
            throw new IllegalStateException(e);
        }
    }
}
