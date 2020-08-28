package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.enums.WaitingType;
import baliviya.com.github.AntiCoreBot.model.custom.*;
import baliviya.com.github.AntiCoreBot.repository.FileRepo;
import baliviya.com.github.AntiCoreBot.repository.TaskArchiveRepo;
import baliviya.com.github.AntiCoreBot.repository.TaskRepo;
import baliviya.com.github.AntiCoreBot.repository.TelegramBotRepositoryProvider;
import baliviya.com.github.AntiCoreBot.util.ButtonsLeaf;
import baliviya.com.github.AntiCoreBot.util.Const;
import baliviya.com.github.AntiCoreBot.util.DateUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class id005_Task extends Command {

    private Task task;
    private TaskRepo        taskRepo        = TelegramBotRepositoryProvider.getTaskRepo();
    private TaskArchiveRepo taskArchiveRepo = TelegramBotRepositoryProvider.getTaskArchiveRepo();
    private FileRepo        fileRepo        = TelegramBotRepositoryProvider.getFileRepo();
    private int             idStatus;
    private int             deleteMessageId;
    private int             secondDeleteMessageId;
    private boolean         isDone;
    private String          photos;
    private List<Task>      taskList;
    private int             count;
    private ButtonsLeaf     buttonsLeaf;
    private int             offset;

    @Override
    public  boolean execute()   throws TelegramApiException {

        if (isButton(Const.COMPLETED_BUTTON_FROM_KEYBOARD)) {
            idStatus = 1;
            getMyTask();
            return COMEBACK;
        }
        if (isButton(Const.NOT_COMPLETED_BUTTON_FROM_KEYBOARD)) {
            idStatus = 2;
            getMyTask();
            return COMEBACK;
        }
        if (isButton(Const.IN_THE_PROCESS_BUTTON)) {
            idStatus = 3;
            getMyTask();
            return COMEBACK;
        }
        switch (waitingType) {
            case START:
                deleteMessage(updateMessageId);
                String text         = update.getCallbackQuery().getMessage().getText();
                int id              = Integer.parseInt(text.split(next)[0].replaceAll("[^0-9]", ""));
                task                = taskRepo.findById(id).get();
                if (isButton(Const.EXCELLENT_BUTTON)) {
                    task.setAppraisal(buttonRepo.findByIdAndLangId(Const.EXCELLENT_BUTTON, getLanguage().getId()).getName());
                    taskRepo.save(task);
                    sendMessage(Const.THNX_FOR_U_ANSWER_MESSAGE);
                }
                if (isButton(Const.WELL_BUTTON)) {
                    task.setAppraisal(buttonRepo.findByIdAndLangId(Const.WELL_BUTTON, getLanguage().getId()).getName());
                    taskRepo.save(task);
                    sendMessage(Const.THNX_FOR_U_ANSWER_MESSAGE);
                }
                if (isButton(Const.SATISFACTORILY_BUTTON)) {
                    task.setAppraisal(buttonRepo.findByIdAndLangId(Const.SATISFACTORILY_BUTTON, getLanguage().getId()).getName());
                    taskRepo.save(task);
                    sendMessage(Const.THNX_FOR_U_ANSWER_MESSAGE);
                }
                if (isButton(Const.DONE_BUTTON)) {
                    idStatus        = 1;
                    isDone          = true;
                    deleteMessageId = sendMessage(Const.ENTER_TEXT_EXPLANATION);
                    waitingType     = WaitingType.DONE;
                }
                if (isButton(Const.NOT_PERFORMED)) {
                    idStatus        = 2;
                    isDone          = false;
                    deleteMessageId = sendMessage(Const.ENTER_TEXT_EXPLANATION);
                    waitingType     = WaitingType.DONE;
                }
                return COMEBACK;
            case DONE:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (hasMessageText()) {
                    TaskArchive taskArchive = new TaskArchive();
                    taskArchive.setTaskId(task.getId());
                    taskArchive.setText(updateMessageText);
                    taskArchiveRepo.save(taskArchive);
                    toDeleteKeyboard(sendMessageWithKeyboard(getText(Const.ATTACH_SKIP_FILE_MESSAGE), Const.ATTACH_SKIP_BUTTONS_KEYBOARD));
                    waitingType             = WaitingType.FILE;
                }
                return COMEBACK;
            case FILE:
                deleteMessage(updateMessageId);
                if (isButton(Const.ATTACH_FILE_BUTTON)) {
                    deleteMessageId = sendMessage(Const.ATTACH_FILE);
                    waitingType     = WaitingType.GET_FILE;
                }
                if (isButton(Const.SKIP_BUTTON)) closeTask();
                if (isButton(Const.COMPLETE_BUTTON)) closeTask();
                return COMEBACK;
            case GET_FILE:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (update.hasMessage()) {
                    if (update.getMessage().getPhoto() != null) {
                        fileRepo.save(fileRepo.findByIdTask(task.getId()).get().setDone(true));
                        for (PhotoSize photo : update.getMessage().getPhoto()) {
                            if (photos == null) {
                                File answerFile = new File();
                                answerFile.setIdTask(task.getId());
                                answerFile.setImg(photo.getFileId());
                                fileRepo.save(answerFile);
                                photos          = photo.getFileId();
                            }
                        }
                    }
                    if (update.getMessage().getVideo() != null) {
                        File file       = fileRepo.findById(task.getId()).get();
                        file.setDone(isDone);
                        fileRepo.save(file);
                        File answerFile = new File();
                        answerFile.setIdTask(task.getId());
                        answerFile.setVideo(update.getMessage().getVideo().getFileId());
                        fileRepo.save(answerFile);
                    }
                }
                toDeleteKeyboard(sendMessageWithKeyboard(getText(Const.DOCUMENT_SENT_MESSAGE), keyboardMarkUpService.select(Const.ATTACH_END_BUTTONS_KEYBOARD)));
                waitingType = WaitingType.FILE;
                photos      = null;
                return COMEBACK;
            case GIVE_INFO:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (hasCallbackQuery()) {
                    if (buttonsLeaf.isNext(updateMessageText)) {
                        changeOffset();
                        getMyTask();
                        return COMEBACK;
                    }
                    int taskId                  = Integer.parseInt(updateMessageText);
                    task                        = taskRepo.findById(taskList.get(taskId).getId()).get();
                    String employeeName         = "";
                    for (Employee employee : employeeRepo.findAllByHandling(task.getHandling())) {
                        employeeName += usersRepo.getByChatId(employee.getEmployeeId()).getFullName() + next;
                    }
                    AppealType appealType       = appealTypeRepo.findByIdAndLangId(task.getHandling(), getLanguage().getId());
                    List<TaskArchive> archives  = taskArchiveRepo.findAllByTaskId(task.getId());
                    StringBuilder sb            = new StringBuilder();
                    sb.append(getText(Const.APPEAL)).append(task.getId()).append(next);
                    sb.append(getText(Const.APPLICANT)).append(usersRepo.getByChatId(task.getPeopleId()).getFullName()).append(next);
                    sb.append(getText(Const.APPEAL_TEXT)).append(task.getTaskText()).append(next);
                    sb.append(getText(Const.APPEAL_DATE)).append(task.getDateBegin()).append(next);
                    sb.append(getText(Const.CATEGORY_APPEAL_MESSAGE)).append(appealType.getName()).append(next);
                    sb.append(getText(Const.RESPONSIBLE)).append(employeeName).append(next);
                    if (archives.size() != 0) {
                        for (TaskArchive taskArchive : archives) {
                            sb.append(taskArchive.getText()).append(next);
                        }
                    }
                    ReplyKeyboard select        = keyboardMarkUpService.select(Const.BACK_BUTTON_KEYBOARD);
                    List<File> files            = fileRepo.findAllByIdTask(task.getId());
                    for (File file : files) {
                        if (file.getImg() != null) {
                            deleteMessageId = bot.execute(new SendPhoto().setChatId(chatId).setPhoto(file.getImg())).getMessageId();
                        } else if (file.getVideo() != null) {
                            deleteMessageId = bot.execute(new SendVideo().setChatId(chatId).setVideo(file.getVideo())).getMessageId();
                        }
                        if (file.getLocation() != null) {
                            SendLocation sendLocation = new SendLocation();
                            sendLocation.setLatitude(Float.parseFloat(file.getLocation().split(Const.SPLIT)[0]));
                            sendLocation.setLongitude(Float.parseFloat(file.getLocation().split(Const.SPLIT)[1]));
                            sendLocation.setChatId(chatId);
                            secondDeleteMessageId = bot.execute(sendLocation).getMessageId();
                        }
                    }
                    toDeleteKeyboard(sendMessageWithKeyboard(sb.toString(), select));
                    waitingType                 = WaitingType.ADD_TEXT;
                }
                return COMEBACK;
            case ADD_TEXT:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                deleteMessage(secondDeleteMessageId);
                if (hasCallbackQuery()) {
                    if (isButton(Const.BACK_BUTTON)) {
                        getMyTask();
                        waitingType = WaitingType.GIVE_INFO;
                    }
                }
                return COMEBACK;
        }
        return EXIT;
    }

    private void    closeTask() throws TelegramApiException {
        int deletePhotoMessageId        = 0;
        Task oldTask                    = taskRepo.findById(task.getId()).get();
        oldTask.setIdStatus(idStatus);
        task                            = taskRepo.save(oldTask);
        List<TaskArchive> taskArchives  = taskArchiveRepo.findAllByTaskId(task.getId());
        String employeeName             = "";
        for (Employee employee : employeeRepo.findAllByHandling(task.getHandling())) {
            employeeName += usersRepo.getByChatId(employee.getEmployeeId()).getFullName() + next;
        }
        StringBuilder sb                = new StringBuilder();
        sb.append(getText(Const.APPEAL) + task.getId()).append(next);
        sb.append(task.getIdStatus() == 1 ? getText(Const.DONE_MESSAGE) : getText(Const.DONT_DONE_MESSAGE)).append(next);
        sb.append(getText(Const.WELCOME_TEXT_MESSAGE)).append("<b>").append(usersRepo.getByChatId(task.getPeopleId()).getFullName()).append("</b>").append(next);
        if (taskArchives.size() != 0) {
            for (TaskArchive taskArchive : taskArchives) {
                sb.append(getText(Const.APPEAL_NUMBER_MESSAGE)).append("<b>").append(task.getId()).append("</b>").append(" от ").append("<b>").append(DateUtil.getDateAndTime(task.getDateBegin())).append("</b>").append(getText(Const.NEXT_MESSAGE_FROM_APPEAL)).append("<code>").append(taskArchive.getText()).append("</code>").append(next);
            }
        }
        List<File> files = fileRepo.findAllByIdTask(task.getId());
        for (File file : files) {
            if (file.getLocation() == null) {
                if (file.getImg() != null) {
                    deletePhotoMessageId = bot.execute(new SendPhoto().setChatId(task.getPeopleId()).setPhoto(file.getImg())).getMessageId();
                } else if (file.getVideo() != null) {
                    deletePhotoMessageId = bot.execute(new SendVideo().setChatId(task.getPeopleId()).setVideo(file.getVideo())).getMessageId();
                }
            }
        }
        sb.append(getText(Const.RATE_THE_SERVICE));
        toDeleteKeyboard(sendMessageWithKeyboard(sb.toString(), keyboardMarkUpService.select(Const.RATE_KEYBOARD), task.getPeopleId()));
        sendMessage(Const.RESPONSE_SENT_MESSAGE);
    }

    private boolean getMyTask() throws TelegramApiException {
        deleteMessage(updateMessageId);
        ArrayList<String> buttonNames   = new ArrayList<>();
        taskList                        = taskRepo.findAllByPeopleIdAndIdStatus(chatId, idStatus);
        if (taskList == null || taskList.size() == 0) {
            deleteMessageId             = sendMessage("Задании нет");
            return EXIT;
        }
        for (Task task : taskList) {
            count   = taskList.size();
            buttonNames.add("#" + task.getId() + " : " + usersRepo.getByChatId(task.getPeopleId()).getFullName());
        }
        buttonsLeaf         = new ButtonsLeaf(buttonNames, 6, "<<", ">>");
        if (count > 6) buttonsLeaf.setAddNextButtons(true);
        deleteMessageId     = toDeleteKeyboard(sendMessageWithKeyboard("Выберите задание", buttonsLeaf.getListButton()));
        waitingType         = WaitingType.GIVE_INFO;
        return COMEBACK;
    }

    private void    changeOffset() {
        if (offset < 0)         offset = (count / 6) * 6;
        if (offset >= count)    offset = 0;
    }
}
