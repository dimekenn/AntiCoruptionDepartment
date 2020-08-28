package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.enums.WaitingType;
import baliviya.com.github.AntiCoreBot.service.AppealService;
import baliviya.com.github.AntiCoreBot.util.Const;
import baliviya.com.github.AntiCoreBot.util.DateKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Date;

public class id010_AppealReport extends Command {

    private DateKeyboard    dateKeyboard;
    private Date            start;
    private Date            end;
    private int             deleteMessageId;

    @Override
    public  boolean execute()           throws TelegramApiException {
        if (!isAdmin()) {
            sendMessage(Const.NO_ACCESS);
            return EXIT;
        }
        switch (waitingType) {
            case START:
                dateKeyboard    = new DateKeyboard();
                deleteMessageId = sendStartDate();
                waitingType     = WaitingType.START_DATE;
                return COMEBACK;
            case START_DATE:
                deleteMessage(updateMessageId);
                if (hasCallbackQuery()) {
                    if (dateKeyboard.isNext(updateMessageText)) {
                        sendStartDate();
                        return COMEBACK;
                    }
                    start           = dateKeyboard.getDateDate(updateMessageText);
                    start.setHours(0);
                    start.setMinutes(0);
                    start.setSeconds(0);
                    deleteMessageId = sendEndDate();
                    waitingType     = WaitingType.END_DATE;
                }
                return COMEBACK;
            case END_DATE:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (hasCallbackQuery()) {
                    if (dateKeyboard.isNext(updateMessageText)) {
                        sendStartDate();
                        return COMEBACK;
                    }
                    end             = dateKeyboard.getDateDate(updateMessageText);
                    end.setHours(23);
                    end.setMinutes(59);
                    end.setSeconds(59);
                    sendReport();
                }
                return COMEBACK;
        }
        return EXIT;
    }

    private int     sendStartDate()     throws TelegramApiException { return toDeleteKeyboard(sendMessageWithKeyboard( "<b>Выберите начальную дату, для подробного отчета ⬇️</b>", dateKeyboard.getCalendarKeyboard())); }

    private int     sendEndDate()       throws TelegramApiException { return toDeleteKeyboard(sendMessageWithKeyboard("<b>Выберите конечную дату</b> ⬇️", dateKeyboard.getCalendarKeyboard())); }

    private void    sendReport()        throws TelegramApiException {
        int preview                 = sendMessage("Отчет подготавливается \uD83D\uDCA4");
        AppealService appealService = new AppealService();
        appealService.sendReports(chatId, bot, start, end, preview);
    }
}
