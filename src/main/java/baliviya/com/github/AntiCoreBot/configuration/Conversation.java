package baliviya.com.github.AntiCoreBot.configuration;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.enums.Language;
import baliviya.com.github.AntiCoreBot.exceptions.CommandNotFoundException;
import baliviya.com.github.AntiCoreBot.model.standart.Message;
import baliviya.com.github.AntiCoreBot.repository.MessageRepo;
import baliviya.com.github.AntiCoreBot.repository.TelegramBotRepositoryProvider;
import baliviya.com.github.AntiCoreBot.service.CommandService;
import baliviya.com.github.AntiCoreBot.service.LanguageService;
import baliviya.com.github.AntiCoreBot.util.Const;
import baliviya.com.github.AntiCoreBot.util.DateUtil;
import baliviya.com.github.AntiCoreBot.util.SetDeleteMessages;
import baliviya.com.github.AntiCoreBot.util.UpdateUtil;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Date;

@Slf4j
public class Conversation {

    private Long            chatId;
    private Command         command;
    private CommandService  commandService  = new CommandService();
    private MessageRepo     messageRepo     = TelegramBotRepositoryProvider.getMessageRepo();
    private static long     currentChatId;

    public          void        handleUpdate(Update update, DefaultAbsSender bot) throws TelegramApiException {
        printUpdate(update);
        chatId          = UpdateUtil.getChatId(update);
        currentChatId   = chatId;
        checkLanguage(chatId);
        try {
            command     = commandService.getCommand(update);
            if (command != null) {
                SetDeleteMessages.deleteKeyboard(chatId, bot);
                SetDeleteMessages.deleteMessage(chatId, bot);
            }
        } catch (CommandNotFoundException e) {
            if (chatId < 0) return;
            if (command == null) {
                SetDeleteMessages.deleteKeyboard(chatId, bot);
                SetDeleteMessages.deleteMessage(chatId, bot);
                Message message = messageRepo.findByIdAndLanguageId(Const.COMMAND_NOT_FOUND, getLanguage().getId());
                bot.execute(new SendMessage().setChatId(chatId).setText(message.getName()));
            }
        }
        if (command != null) {
            if (command.isInitNormal(update, bot)) {
                clear();
                return;
            }
            boolean commandFinished = command.execute();
            if (commandFinished) clear();
        }
    }

    private         void        printUpdate(Update update) {
        String dataMessage = "";
        if (update.hasMessage()) dataMessage = DateUtil.getDbMmYyyyHhMmSs(new Date((long) update.getMessage().getDate() * 1000));
        log.info("New update get {} -> send response {}", dataMessage, DateUtil.getDbMmYyyyHhMmSs(new Date()));
        log.info(UpdateUtil.toString(update));
    }

    private         void        checkLanguage(long chatId) { if (LanguageService.getLanguage(chatId) == null) LanguageService.setLanguage(chatId, Language.ru); }

    public static   long        getCurrentChatId() { return currentChatId; }

    private         Language    getLanguage() {
        if (chatId == 0) return Language.ru;
        return LanguageService.getLanguage(chatId);
    }

    private         void        clear() {
        command.clear();
        command = null;
    }
}
