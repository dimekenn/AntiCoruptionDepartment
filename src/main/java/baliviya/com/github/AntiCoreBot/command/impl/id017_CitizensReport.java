package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.enums.WaitingType;
import baliviya.com.github.AntiCoreBot.service.CitizenReportService;
import baliviya.com.github.AntiCoreBot.util.Const;
import baliviya.com.github.AntiCoreBot.util.DateKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Date;

public class id017_CitizensReport extends Command {

    private int deleteMessageId;
    private String suggestionType;
    private DateKeyboard dateKeyboard;
    private Date start;
    private Date end;

    @Override
    public boolean execute() throws TelegramApiException {

        if (!isCitizenEmployee()) {
            sendMessage(Const.NO_ACCESS);
            return EXIT;
        }

        switch (waitingType){
            case START:
                deleteMessage(updateMessageId);
                dateKeyboard = new DateKeyboard();
                deleteMessageId = sendStartDate();
                waitingType = WaitingType.START_DATE;
                return COMEBACK;
            case START_DATE:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (hasCallbackQuery()){
                    if (dateKeyboard.isNext(updateMessageText)){
                        sendStartDate();
                        return COMEBACK;
                    }
                    start = dateKeyboard.getDateDate(updateMessageText);
                    start.setHours(0);
                    start.setMinutes(0);
                    start.setSeconds(0);
                    sendEndDate();
                    waitingType = WaitingType.END_DATE;
                }
                return COMEBACK;
            case END_DATE:
                deleteMessage(updateMessageId);
                if (hasCallbackQuery()) {
                    if (dateKeyboard.isNext(updateMessageText)) {
                        sendStartDate();
                        return COMEBACK;
                    }
                    end = dateKeyboard.getDateDate(updateMessageText);
                    end.setHours(23);
                    end.setMinutes(59);
                    end.setSeconds(59);
                    sendReport();
                    waitingType = WaitingType.END_DATE;
                }
                return COMEBACK;
        }
        return EXIT;
    }

    private int sendStartDate() throws TelegramApiException {
        return toDeleteKeyboard(sendMessageWithKeyboard(getText(1053), dateKeyboard.getCalendarKeyboard()));
    }

    private int sendEndDate() throws TelegramApiException {
        return toDeleteKeyboard(sendMessageWithKeyboard(1054, dateKeyboard.getCalendarKeyboard()));
    }

    private void sendReport() throws TelegramApiException {
        int preview = sendMessage("Отчет подготавливается...");
        CitizenReportService reportService = new CitizenReportService();
        reportService.sendCitizenReport(chatId, bot, start, end, suggestionType, preview);
    }
}
