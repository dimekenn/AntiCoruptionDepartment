package baliviya.com.github.AntiCoreBot.service;

import baliviya.com.github.AntiCoreBot.enums.WaitingType;
import baliviya.com.github.AntiCoreBot.model.standart.User;
import baliviya.com.github.AntiCoreBot.repository.MessageRepo;
import baliviya.com.github.AntiCoreBot.repository.TelegramBotRepositoryProvider;
import baliviya.com.github.AntiCoreBot.util.BotUtil;
import baliviya.com.github.AntiCoreBot.util.ButtonsLeaf;
import baliviya.com.github.AntiCoreBot.util.Const;
import baliviya.com.github.AntiCoreBot.util.UpdateUtil;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Service
public class RegistrationService {

    private User            user;
    private long            chatId;
    private BotUtil         botUtil;
    private WaitingType     waitingType = WaitingType.START;
    private boolean         COMEBACK    = false;
    private boolean         EXIT        = true;

    public  boolean isRegistration(Update update, BotUtil botUtil)  throws TelegramApiException {
        if (botUtil == null || chatId == 0) {
            chatId       = UpdateUtil.getChatId(update);
            this.botUtil = botUtil;
        }
        switch (waitingType) {
            case START:
                user        = new User();
                user.setChatId(chatId);
                getName();
                waitingType = WaitingType.SET_FULL_NAME;
                return COMEBACK;
            case SET_FULL_NAME:
                if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().length() <= 50) {
                    user.setFullName(update.getMessage().getText());
                    getPhone();
                    waitingType = WaitingType.SET_PHONE_NUMBER;
                } else {
                    wrongData();
                    getName();
                }
                return COMEBACK;
            case SET_PHONE_NUMBER:
                if (botUtil .hasContactOwner(update)) {
                    user.setPhone(update.getMessage().getContact().getPhoneNumber());
                    user.setUsername(UpdateUtil.getFrom(update));
                    return EXIT;
                } else {
                    wrongData();
                    getPhone();
                    return COMEBACK;
                }
        }
        return EXIT;
    }

    private int     wrongData()                                     throws TelegramApiException { return botUtil.sendMessage(Const.WRONG_DATA_TEXT, chatId); }

    private int     getName()                                       throws TelegramApiException { return botUtil.sendMessage(Const.SET_FULL_NAME_MESSAGE, chatId); }

    private int     getPhone()                                      throws TelegramApiException { return botUtil.sendMessage(Const.SEND_CONTACT_MESSAGE, chatId); }

    public  User    getUser() { return user; }
}
