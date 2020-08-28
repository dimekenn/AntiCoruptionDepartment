package baliviya.com.github.AntiCoreBot.command;

import baliviya.com.github.AntiCoreBot.dao.DaoFactory;
import baliviya.com.github.AntiCoreBot.dao.impl.AppealTypeDao;
import baliviya.com.github.AntiCoreBot.dao.impl.ButtonDao;
import baliviya.com.github.AntiCoreBot.dao.impl.KeyboardMarkUpDao;
import baliviya.com.github.AntiCoreBot.dao.impl.MessageDao;
import baliviya.com.github.AntiCoreBot.enums.Language;
import baliviya.com.github.AntiCoreBot.enums.WaitingType;
import baliviya.com.github.AntiCoreBot.model.standart.Button;
import baliviya.com.github.AntiCoreBot.repository.*;
import baliviya.com.github.AntiCoreBot.service.KeyboardMarkUpService;
import baliviya.com.github.AntiCoreBot.service.LanguageService;
import baliviya.com.github.AntiCoreBot.util.BotUtil;
import baliviya.com.github.AntiCoreBot.util.SetDeleteMessages;
import baliviya.com.github.AntiCoreBot.util.UpdateUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@Slf4j
public abstract class Command {

    @Getter
    @Setter
    protected long id;
    @Getter
    @Setter
    protected long messageId;
    protected static BotUtil botUtils;
    protected Update update;
    protected DefaultAbsSender bot;
    protected Long chatId;
    protected Message updateMessage;
    protected String updateMessageText;
    protected int updateMessageId;
    protected String editableTextOfMessage;
    protected String updateMessagePhoto;
    protected String updateMessagePhone;
    protected String markChange = "✏️";
    protected int lastSendMessageID;
    protected final static String linkEdit = "/linkId";
    protected final static String next = "\n";
    protected final static String space = " ";
    protected WaitingType waitingType = WaitingType.START;
    protected final static boolean EXIT = true;
    protected final static boolean COMEBACK = false;
    protected KeyboardMarkUpService keyboardMarkUpService = new KeyboardMarkUpService();
    protected MessageRepo messageRepo = TelegramBotRepositoryProvider.getMessageRepo();
    protected UsersRepo usersRepo = TelegramBotRepositoryProvider.getUserRepo();
    protected ButtonRepo buttonRepo = TelegramBotRepositoryProvider.getButtonRepo();
    protected AppealTypeRepo appealTypeRepo = TelegramBotRepositoryProvider.getAppealTypeRepo();
    protected EmployeeRepo employeeRepo = TelegramBotRepositoryProvider.getEmployeeRepo();
    protected ReceptionRepo receptionRepo = TelegramBotRepositoryProvider.getReceptionRepo();
    protected AdminRepo adminRepo = TelegramBotRepositoryProvider.getAdminRepo();
    protected KeyboardRepo keyboardRepo = TelegramBotRepositoryProvider.getKeyboardRepo();
    protected CitizenEmployeeRepo citizenEmployeeRepo = TelegramBotRepositoryProvider.getCitizenEmployeeRepo();
    protected CitizensRegistrationRepo citizensRegistrationRepo = TelegramBotRepositoryProvider.getCitizensRegistrationRepo();
    protected SendMemberRepo sendMemberRepo = TelegramBotRepositoryProvider.getSendMemberRepo();

    protected DaoFactory daoFactory = DaoFactory.getFactory();
    protected AppealTypeDao appealTypeDao = daoFactory.getAppealTypeDao();
    protected KeyboardMarkUpDao keyboardMarkUpDao = daoFactory.getKeyboardMarkUpDao();
    protected ButtonDao buttonDao = daoFactory.getButtonDao();
    protected MessageDao messageDao = daoFactory.getMessageDao();

    public abstract boolean execute() throws TelegramApiException;

    protected int sendMessageWithKeyboard(int messageId, ReplyKeyboard keyboard) throws TelegramApiException {
        return sendMessageWithKeyboard(getText(messageId), keyboard);
    }

    protected int sendMessageWithKeyboard(String text, ReplyKeyboard keyboard) throws TelegramApiException {
        lastSendMessageID = sendMessageWithKeyboard(text, keyboard, chatId);
        return lastSendMessageID;
    }

    protected int sendMessageWithKeyboard(String text, ReplyKeyboard keyboard, long chatId) throws TelegramApiException {
        return botUtils.sendMessageWithKeyboard(text, keyboard, chatId);
    }

    public boolean isInitNormal(Update update, DefaultAbsSender bot) {
        if (botUtils == null) botUtils = new BotUtil(bot);
        this.update = update;
        this.bot = bot;
        chatId = UpdateUtil.getChatId(update);
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            updateMessage = callbackQuery.getMessage();
            updateMessageText = callbackQuery.getData();
            updateMessageId = updateMessage.getMessageId();
            editableTextOfMessage = callbackQuery.getMessage().getText();
        } else if (update.hasMessage()) {
            updateMessage = update.getMessage();
            updateMessageId = updateMessage.getMessageId();
            if (updateMessage.hasText()) updateMessageText = updateMessage.getText();
            if (updateMessage.hasPhoto()) {
                int size = update.getMessage().getPhoto().size();
                updateMessagePhoto = update.getMessage().getPhoto().get(size - 1).getFileId();
            } else {
                updateMessagePhoto = null;
            }
        }
        if (hasContact()) updateMessagePhone = update.getMessage().getContact().getPhoneNumber();
//        if (markChange == null) markChange      = getText(Const.EDIT_BUTTON_ICON);
        return COMEBACK;
    }

    protected boolean hasContact() {
        return update.hasMessage() && update.getMessage().getContact() != null;
    }

    protected String getText(int messageIdFromDb) {
        return messageRepo.findByIdAndLanguageId(messageIdFromDb, getLanguage().getId()).getName();
    }

    protected void deleteMessage(int messageId) {
        deleteMessage(chatId, messageId);
    }

    protected void deleteMessage(long chatId, int messageId) {
        botUtils.deleteMessage(chatId, messageId);
    }

    public void clear() {
        update = null;
        bot = null;
    }

    protected int sendMessage(long messageId) throws TelegramApiException {
        return sendMessage(messageId, chatId);
    }

    protected int sendMessage(long messageId, long chatId) throws TelegramApiException {
        return sendMessage(messageId, chatId, null);
    }

    protected int sendMessage(long messageId, long chatId, Contact contact) throws TelegramApiException {
        return sendMessage(messageId, chatId, contact, null);
    }

    protected int sendMessage(long messageId, long chatId, Contact contact, String photo) throws TelegramApiException {
        lastSendMessageID = botUtils.sendMessage(messageId, chatId, contact, photo);
        return lastSendMessageID;
    }

    protected void sendMessageWithAddition() throws TelegramApiException {
        deleteMessage(updateMessageId);
        int languageId = getLanguage().getId();
        baliviya.com.github.AntiCoreBot.model.standart.Message message = messageRepo.findByIdAndLanguageId((int) messageId, languageId);
        try {
            if (message.getFile() != null) {
                switch (message.getFileType()) {
                    case "photo":
                        bot.execute(new SendPhoto().setPhoto(message.getFile()).setChatId(chatId));
                        break;
                    case "audio":
                        bot.execute(new SendAudio().setAudio(message.getFile()).setChatId(chatId));
                        break;
                    case "video":
                        bot.execute(new SendVideo().setVideo(message.getFile()).setChatId(chatId));
                        break;
                    case "document":
                        bot.execute(new SendDocument().setChatId(chatId).setDocument(message.getFile()));
                        break;
                }
            }
            sendMessage(messageId, chatId, null, message.getPhoto());
        } catch (TelegramApiException e) {
            log.error("Exception by send file for message " + messageId, e);
        }
    }

    protected boolean isRegistered() {
        return usersRepo.countUserByChatId(chatId) > 0;
    }

    protected boolean isButton(int buttonId) {
        Button button = buttonRepo.findByIdAndLangId(buttonId, getLanguage().getId());
        return updateMessageText.equals(button.getName());
    }

    protected int toDeleteMessage(int messageDeleteId) {
        SetDeleteMessages.addKeyboard(chatId, messageDeleteId);
        return messageDeleteId;
    }

    protected int sendMessage(String text) throws TelegramApiException {
        return sendMessage(text, chatId);
    }

    protected int sendMessage(String text, long chatId) throws TelegramApiException {
        return sendMessage(text, chatId, null);
    }

    protected int sendMessage(String text, long chatId, Contact contact) throws TelegramApiException {
        lastSendMessageID = botUtils.sendMessage(text, chatId);
        if (contact != null) botUtils.sendContact(chatId, contact);
        return lastSendMessageID;
    }

    protected int toDeleteKeyboard(int messageDeleteId) {
        SetDeleteMessages.addKeyboard(chatId, messageDeleteId);
        return messageDeleteId;
    }

    protected boolean isCitizenEmployee() {
        return daoFactory.getCitizensEmployeeDao().isCitizenEmployee(chatId);
    }

    protected boolean hasCallbackQuery() {
        return update.hasCallbackQuery();
    }

    protected boolean hasMessageText() {
        return update.hasMessage() && update.getMessage().hasText();
    }

    protected Language getLanguage() {
        if (chatId == 0) return Language.ru;
        return LanguageService.getLanguage(chatId);
    }

    protected int sendMessageWithKeyboard(String text, int keyboardId) throws TelegramApiException {
        return sendMessageWithKeyboard(text, keyboardMarkUpService.select(keyboardId));
    }

    protected int sendMessageWithKeyboardTest(String text, ReplyKeyboard keyboard, long chatID) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage().setParseMode(ParseMode.HTML).setChatId(chatID).setText(text).setReplyMarkup(keyboard);
        sendMessageTest(text, sendMessage);
        return lastSendMessageID;
    }

    private void sendMessageTest(String text, SendMessage sendMessage) throws TelegramApiException {
        try {
            lastSendMessageID = bot.execute(sendMessage).getMessageId();
        } catch (TelegramApiRequestException e) {
            if (e.getApiResponse().contains("Bad Request: can't parse entities")) {
                sendMessage.setParseMode(null);
                sendMessage.setText(text + next + "Wrong number");
                lastSendMessageID = bot.execute(sendMessage).getMessageId();
            } else throw e;
        }
    }

    protected boolean isEmployee() {
        return employeeRepo.countAllByEmployeeId(chatId) > 0;
    }

    protected boolean isEmployee(long chatId, int handlingId) {
        return employeeRepo.countAllByEmployeeIdAndHandling(chatId, handlingId) > 0;
    }

    protected boolean isAdmin() {
        int count = adminRepo.countByChatId(chatId);
        if (count > 0) return EXIT;
        return COMEBACK;
    }

    protected boolean isAdmin(long chatId) {
        int count = adminRepo.countByChatId(chatId);
        if (count > 0) return EXIT;
        return COMEBACK;
    }

    protected boolean isUser(long chatId) {
        int count = usersRepo.countUserByChatId(chatId);
        if (count > 0) return EXIT;
        return COMEBACK;
    }

    protected String getLinkForUser(long chatId, String userName) {
        return String.format("<a href = \"tg://user?id=%s\">%s</a>", chatId, userName);
    }

    protected boolean hasPhoto() {
        return update.hasMessage() && update.getMessage().hasPhoto();
    }

    protected boolean hasDocument() {
        return update.hasMessage() && update.getMessage().hasDocument();
    }

    protected boolean hasAudio() {
        return update.hasMessage() && update.getMessage().getAudio() != null;
    }

    protected boolean hasVideo() {
        return update.hasMessage() && update.getMessage().getVideo() != null;
    }
}
