package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.enums.WaitingType;
import baliviya.com.github.AntiCoreBot.model.custom.*;
import baliviya.com.github.AntiCoreBot.repository.*;
import baliviya.com.github.AntiCoreBot.service.KeyboardMarkUpService;
import baliviya.com.github.AntiCoreBot.util.ButtonsLeaf;
import baliviya.com.github.AntiCoreBot.util.Const;
import baliviya.com.github.AntiCoreBot.util.DateUtil;
import baliviya.com.github.AntiCoreBot.util.IKeyboardOld;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class id004_SendAnAppeal extends Command {

    private List<AppealType>    allAppealType;
    private ButtonsLeaf         buttonsLeaf;
    private Date                dateBegin;
    private Task                task;
    private AppealType          appealType;
    private TaskRepo            taskRepo        = TelegramBotRepositoryProvider.getTaskRepo();
    private FileRepo            fileRepo        = TelegramBotRepositoryProvider.getFileRepo();
    private EmployeeRepo        employeeRepo    = TelegramBotRepositoryProvider.getEmployeeRepo();
    private SimpleDateFormat    dateFormat      = new SimpleDateFormat("yyyy-MM-dd");
    private File                file;
    private int                 taskId;
    private int                 deleteMessageId;
    private int                 secondDeleteMessageId;


    @Override
    public  boolean execute()                                                   throws TelegramApiException {
        switch (waitingType) {
            case START:
                deleteMessage(updateMessageId);
                allAppealType       = appealTypeRepo.findAllByLangId(getLanguage().getId());
                if (allAppealType == null || allAppealType.size() == 0) {
                    sendMessage(Const.EMPTY_MESSAGE);
                    return EXIT;
                }
                List<String> list   = new ArrayList<>();
                allAppealType.forEach(appealType -> list.add(appealType.getName()));
                buttonsLeaf         = new ButtonsLeaf(list);
                toDeleteKeyboard(sendMessageWithKeyboard(Const.SELECT_A_CATEGORY_APPEAL, buttonsLeaf.getListButton()));
                waitingType         = WaitingType.SELECT_APPEAL_TYPE;
                return COMEBACK;
            case SELECT_APPEAL_TYPE:
                deleteMessage(updateMessageId);
                if (hasCallbackQuery()) {
                    dateBegin       = new Date();
                    task            = new Task();
                    task.setIdStatus(3);
                    task.setPeopleId(chatId);
                    task.setDateBegin(dateBegin);
                    task.setTimeTask(DateUtil.getTimeDate(dateBegin));
                    appealType      = allAppealType.get(Integer.parseInt(updateMessageText));
                    task.setHandling(appealType.getId());
                    deleteMessageId = getAppealText();
                    waitingType     = WaitingType.SEND_APPEAL_TEXT;
                } else {
                    toDeleteKeyboard(sendMessageWithKeyboard(Const.SELECT_A_CATEGORY_APPEAL, buttonsLeaf.getListButton()));
                }
                return COMEBACK;
            case SEND_APPEAL_TEXT:
                delete();
                if (hasMessageText()) {
                    task.setTaskText(updateMessageText);
                    task.setMessageId(update.getMessage().getMessageId());
                    deleteMessageId = getAttachFile();
                    waitingType     = WaitingType.FILE;
                } else {
                    secondDeleteMessageId   = wrongData();
                    deleteMessageId         = getAppealText();
                }
                return COMEBACK;
            case FILE:
                delete();
                taskId                      = taskRepo.save(task).getId();
                if (update.hasMessage()) {
                    if (update.getMessage().getPhoto() != null) {
                        file                = new File();
                        file.setImg(updateMessagePhoto);
                        file.setIdTask(taskId);
                        deleteMessageId     = getLocation();
                        waitingType         = WaitingType.LOCATION;
                    } else {
                        deleteMessageId         = wrongData();
                        secondDeleteMessageId   = getAttachFile();
                    }
                } else {
                    deleteMessageId         = wrongData();
                    secondDeleteMessageId   = getAttachFile();
                }
                return COMEBACK;
            case LOCATION:
                delete();
                if (update.getMessage().hasLocation()) {
                    file.setLocation(update.getMessage().getLocation().getLatitude() + Const.SPLIT + update.getMessage().getLocation().getLongitude());
                    fileRepo.save(file);
                    StringBuilder employeeName  = new StringBuilder();
                    for (Employee employeeNames : employeeRepo.findAllByHandling(task.getHandling())) {
                        employeeName.append(usersRepo.getByChatId(employeeNames.getEmployeeId()).getFullName()).append(next);
                    }
                    String fullName             = usersRepo.getByChatId(task.getPeopleId()).getFullName();
                    sendMessageToUser(taskId, employeeName);
                    sendMessageToEmployee(fullName, dateBegin, task.getTaskText(), taskId, employeeName);
                } else {
                    deleteMessageId             = wrongData();
                    secondDeleteMessageId       = getLocation();
                    return COMEBACK;
                }
                return EXIT;
        }
        return EXIT;
    }

    private int     getAppealText()                                             throws TelegramApiException { return botUtils.sendMessage(Const.SEND_DETAIL_APPEAL_MESSAGE, chatId); }

    private int     getAttachFile()                                             throws TelegramApiException { return botUtils.sendMessage(Const.ATTACH_FILE, chatId); }

    private int     getLocation()                                               throws TelegramApiException { return botUtils.sendMessage(Const.SEND_GEOLOCATION, chatId); }

    private int     wrongData()                                                 throws TelegramApiException { return botUtils.sendMessage(Const.WRONG_DATA_TEXT, chatId); }

    private void    sendMessageToUser(int taskId, StringBuilder employeeName)   throws TelegramApiException {
        StringBuilder messageToUser = new StringBuilder();
        messageToUser.append(getText(Const.APPEAL_ACCEPTED)).append(next);
        messageToUser.append(getText(Const.APPEAL) + taskId).append(next);
        messageToUser.append(getText(Const.RESPONSIBLE)).append(employeeName).append(next);
        toDeleteMessage(sendMessage(messageToUser.toString()));
    }

    private void    sendMessageToEmployee(String name, Date dateBegin, String text, int taskId, StringBuilder employeeName) {
        StringBuilder messageToEmployee             = new StringBuilder();
        KeyboardMarkUpService keyboardMarkUpService = new KeyboardMarkUpService();
        ReplyKeyboard select                        = keyboardMarkUpService.select(Const.DONE_BUTTON_KEYBOARD);
        String deadlines                            = dateFormat.format(dateBegin);
        messageToEmployee.append(getText(Const.APPEAL) + taskId).append(next);
        messageToEmployee.append(getText(Const.APPLICANT)).append(name).append(next);
        messageToEmployee.append(getText(Const.APPEAL_TEXT)).append(text).append(next);
        messageToEmployee.append(getText(Const.APPEAL_DATE)).append(deadlines).append(next);
        messageToEmployee.append(getText(Const.RESPONSIBLE)).append(employeeName).append(next);
        for (Employee employee : employeeRepo.findAllByHandling(task.getHandling())) {
            long directId       = employee.getEmployeeId();
            IKeyboardOld kb     = new IKeyboardOld();
            kb.next();
            List<File> fileList = fileRepo.findAllByIdTask(taskId);
            for (File doc : fileList) {
                try {
                    if (doc.getImg() != null) {
                        int messageId = bot.execute(new SendPhoto().setChatId(directId).setPhoto(doc.getImg())).getMessageId();
                    }
                    if (doc.getVideo() != null) {
                        int messageId = bot.execute(new SendVideo().setChatId(directId).setVideo(doc.getVideo())).getMessageId();
                    }
                    SendLocation sendLocation = new SendLocation();
                    sendLocation.setLatitude (Float.parseFloat(doc.getLocation().split(";")[0]));
                    sendLocation.setLongitude(Float.parseFloat(doc.getLocation().split(";")[1]));
                    int messageId = bot.execute(sendLocation.setChatId(directId)).getMessageId();
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            try {
                sendMessageWithKeyboardTest(messageToEmployee.toString(), select, directId);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private void    delete() {
        deleteMessage(updateMessageId);
        deleteMessage(deleteMessageId);
        deleteMessage(secondDeleteMessageId);
    }
}
