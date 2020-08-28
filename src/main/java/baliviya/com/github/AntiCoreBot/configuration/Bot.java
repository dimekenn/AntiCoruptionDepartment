package baliviya.com.github.AntiCoreBot.configuration;

import baliviya.com.github.AntiCoreBot.repository.PropertiesRepo;
import baliviya.com.github.AntiCoreBot.repository.TelegramBotRepositoryProvider;
import baliviya.com.github.AntiCoreBot.util.Const;
import baliviya.com.github.AntiCoreBot.util.UpdateUtil;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Bot extends TelegramLongPollingBot {

    private PropertiesRepo propertiesRepo = TelegramBotRepositoryProvider.getPropertiesRepo();
    private Map<Long, Conversation> conversations = new HashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        Conversation conversation = getConversation(update);
        try {
            conversation.handleUpdate(update, this);
        } catch (TelegramApiException e) {
            log.error("Error " + e);
        }
    }

    private Conversation getConversation(Update update) {
        Long chatId = UpdateUtil.getChatId(update);
        Conversation conversation = conversations.get(chatId);
        if (conversation == null) {
            log.info("InitNormal new conversation for '{}'", chatId);
            conversation = new Conversation();
            conversations.put(chatId, conversation);
        }
        return conversation;
    }

    @Override
    public String getBotUsername() {
        return propertiesRepo.findById(Const.BOT_NAME).get().getValue();
    }

    @Override
    public String getBotToken() {
        return propertiesRepo.findById(Const.BOT_TOKEN).get().getValue();
    }
}
