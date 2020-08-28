package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.enums.FileType;
import baliviya.com.github.AntiCoreBot.enums.Language;
import baliviya.com.github.AntiCoreBot.enums.WaitingType;
import baliviya.com.github.AntiCoreBot.model.standart.Button;
import baliviya.com.github.AntiCoreBot.model.standart.Message;
import baliviya.com.github.AntiCoreBot.service.LanguageService;
import baliviya.com.github.AntiCoreBot.util.ButtonUtil;
import baliviya.com.github.AntiCoreBot.util.Const;
import baliviya.com.github.AntiCoreBot.util.ParserMessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Slf4j
public class id013_EditMenu extends Command {

    private Language currentLanguage;
    private int buttonId;
    private long keyboardMarkUpId;
    private Button currentButton;
    private int textId;
    private int photoId;
    private Message message;
    private int keyId;
    private boolean isUrl = false;
    private int buttonLinkId;
    private final static String NAME = "name:";
    private final static String LINK = "link:";

    @Override
    public boolean execute() throws TelegramApiException {
        if (!isAdmin()) {
            sendMessage(Const.NO_ACCESS);
            return EXIT;
        }
        switch (waitingType) {
            case START:
                deleteMessage(updateMessageId);
                currentLanguage = LanguageService.getLanguage(chatId);
                sendListMenu();
                return COMEBACK;
            case CHOICE_OPTION:
                deleteMessage(updateMessageId);
                if (hasCallbackQuery()) {
                    buttonId = Integer.parseInt(updateMessageText);
                    currentButton = buttonRepo.findByIdAndLangId(buttonId, currentLanguage.getId());
                    if (currentButton.getMessageId() != null)
                        keyboardMarkUpId = messageRepo.findByIdAndLanguageId(currentButton.getMessageId(), currentLanguage.getId()).getKeyboardId();
                    sendEditor();
                } else {
                    sendListMenu();
                }
                return COMEBACK;
            case COMMAND_EDITOR:
                isCommand();
                return COMEBACK;
            case NEXT_KEYBOARD:
                if (hasCallbackQuery()) {
                    buttonId = Integer.parseInt(updateMessageText);
                    currentButton = buttonRepo.findByIdAndLangId(buttonId, currentLanguage.getId());
                    waitingType = WaitingType.CHOICE_OPTION;
                    return COMEBACK;
                } else {
                    sendListMenu();
                }
                return COMEBACK;
            case UPDATE_BUTTON:
                if (isCommand()) return COMEBACK;
                if (hasMessageText()) {
                    String buttonName = (ButtonUtil.getButtonName(updateMessageText, 100));
                    if (buttonName.replaceAll("[0-9]", "").isEmpty()) {
                        sendMessage(Const.WRONG_NAME_FROM_BUTTON_MESSAGE);
                        return COMEBACK;
                    }
                    if (buttonRepo.countByNameAndLangId(buttonName, currentLanguage.getId()) > 0) {
                        sendMessage(Const.NAME_IS_ALREADY_IN_USE_MESSAGE);
                        return COMEBACK;
                    }
                    currentButton.setName(buttonName);
                    //buttonRepo.save(currentButton);
                    buttonDao.update(currentButton);
                    sendEditor();
                }
                return COMEBACK;
            case UPDATE_TEXT:
                if (isCommand()) return COMEBACK;
                if (hasMessageText()) {
                    message.setName(new ParserMessageEntity().getTextWithEntity(update.getMessage()));
                    //messageRepo.save(message);
                    messageDao.update(message);
                    sendEditor();
                }
                return COMEBACK;
            case UPDATE_BUTTON_LINK:
                if (isCommand()) return COMEBACK;
                if (hasMessageText()) {
                    if (updateMessageText.startsWith(NAME)) {
                        String buttonName = ButtonUtil.getButtonName(updateMessageText.replace(NAME, ""));
                        if (buttonRepo.countByNameAndLangId(buttonName, currentLanguage.getId()) > 0) {
                            sendMessage(Const.NAME_IS_ALREADY_IN_USE_MESSAGE);
                            return COMEBACK;
                        }
                        Button button = buttonRepo.findByIdAndLangId(buttonLinkId, currentLanguage.getId());
                        button.setName(buttonName);
                        buttonRepo.save(button);
                        sendEditor();
                        return COMEBACK;
                    } else if (updateMessageText.startsWith(LINK)) {
                        Button button = buttonRepo.findByIdAndLangId(buttonLinkId, currentLanguage.getId());
                        button.setUrl(updateMessageText.replace(LINK, ""));
                        buttonRepo.save(button);
                        sendEditor();
                        return COMEBACK;
                    } else {
                        sendMessage(Const.LINK_EDIT_MESSAGE);
                    }
                }
                sendMessage(Const.LINK_EDIT_MESSAGE);
                return COMEBACK;
            case UPDATE_FILE:
                if (hasDocument() || hasAudio() || hasVideo() || hasPhoto()) {
                    if (!isHasMessageForEdit()) return COMEBACK;
                    updateFile();
                    sendMessage(Const.FILE_SUCCESS_SEND_MESSAGE);
                    sendEditor();
                }
                return COMEBACK;
        }
        return EXIT;
    }

    private void sendListMenu() throws TelegramApiException {
        toDeleteKeyboard(sendMessageWithKeyboard(Const.LIST_EDIT_MENU_MESSAGE, keyboardMarkUpService.selectForEdition(Const.MAIN_MENU, currentLanguage)));
        waitingType = WaitingType.CHOICE_OPTION;
    }

    private void sendEditor() throws TelegramApiException {
        clearOld();
        loadElements();
        String desc;
        if (message != null) {
            keyId = message.getKeyboardId().intValue();
            if (message.getPhoto() != null)
                photoId = bot.execute(new SendPhoto().setPhoto(message.getPhoto()).setChatId(chatId)).getMessageId();
            StringBuilder urlList = new StringBuilder();
            if (keyId != 0 && keyboardMarkUpDao.isInline(keyId)) {
                urlList.append(getText(Const.BUTTON_LINKS)).append(next);
                List<Button> list = keyboardMarkUpService.getListForEdit(keyId);
                for (Button button : list)
                    if (button.getUrl() != null)
                        urlList.append(linkEdit).append(button.getId()).append(" ").append(button.getName()).append(" - ").append(button.getUrl()).append(next);
            }
            desc = String.format(getText(Const.BUTTON_EDIT_MESSAGE), currentButton.getName(), message.getName(), urlList, currentLanguage.name());
            if (desc.length() > getMaxSizeMessage()) {
                String substring = message.getName().substring(0, desc.length() - getMaxSizeMessage() - 3) + "...";
                desc = String.format(getText(Const.TEXT_MENU_EDIT_BUTTON_LINKS), currentButton.getName(), substring, currentLanguage.name());
            }
        } else {
            desc = String.format(getText(Const.TEXT_MENU_EDIT_BUTTON_LINKS), currentButton.getName(), getText(Const.DO_NOT_CHANGE_TEXT_THIS_BUTTON), currentLanguage.name());
        }
        textId = sendMessageWithKeyboard(desc, Const.KEYBOARD_EDIT_BUTTON_ID);
        toDeleteKeyboard(textId);
        waitingType = WaitingType.COMMAND_EDITOR;
    }

    private boolean isCommand() throws TelegramApiException {
        deleteMessage(updateMessageId);
        if (hasPhoto()) {
            if (!isHasMessageForEdit()) return COMEBACK;
            updatePhoto();
        } else if (hasDocument() || hasAudio() || hasVideo()) {
            if (!isHasMessageForEdit()) return COMEBACK;
            updateFile();
        } else if (isButton(Const.CHANGE_BUTTON_NAME)) {
            sendMessage(Const.INTER_TITLE_FROM_BUTTON_MESSAGE);
            waitingType = WaitingType.UPDATE_BUTTON;
            return EXIT;
        } else if (isButton(Const.CHANGE_BUTTON_TEXT)) {
            if (!isHasMessageForEdit()) return COMEBACK;
            sendMessage(Const.SEND_NEW_MESSAGE_FOR_BUTTON);
            waitingType = WaitingType.UPDATE_TEXT;
            return EXIT;
        } else if (isButton(Const.ADD_FILE_BUTTON)) {
            sendMessage(Const.SEND_FILE_MESSAGE);
            waitingType = WaitingType.UPDATE_FILE;
            return EXIT;
        } else if (isButton(Const.DELETE_FILE_BUTTON)) {
            if (!isHasMessageForEdit()) return COMEBACK;
            deleteFile();
        } else if (isButton(Const.CHANGE_LANGUAGE_BUTTON)) {
            if (currentLanguage == Language.ru) {
                currentLanguage = Language.kz;
            } else if (currentLanguage == Language.kz) {
                currentLanguage = Language.en;
            } else {
                currentLanguage = Language.ru;
            }
            currentButton = buttonRepo.findByIdAndLangId(buttonId, currentLanguage.getId());
            sendEditor();
            return EXIT;
        } else if (isButton(Const.NEXT_BUTTON)) {
            deleteMessage(updateMessageId);
            deleteMessage(textId);
            if (keyboardMarkUpId != 0) isUrl = getButtonIds((int) keyboardMarkUpId);
            if (keyboardMarkUpId == 2) {
                currentButton = buttonRepo.findByIdAndLangId(buttonId, currentLanguage.getId());
                sendEditor();
                return COMEBACK;
            } else if (keyboardMarkUpId > 0) {
                if (!isUrl) {
                    toDeleteKeyboard(sendMessageWithKeyboard(Const.CHOICE_WHAT_U_WANT_EDIT_MESSAGE, keyboardMarkUpService.selectForEdition(keyboardMarkUpId, currentLanguage)));
                    waitingType = WaitingType.NEXT_KEYBOARD;
                } else {
                    currentButton = buttonRepo.findByIdAndLangId(buttonId, currentLanguage.getId());
                    sendEditor();
                    return COMEBACK;
                }
            }
        } else if (updateMessageText.startsWith(linkEdit)) {
            String buttId = updateMessageText.replace(linkEdit, "");
            if (keyboardMarkUpService.getButtonString(keyId).contains(buttId)) {
                sendMessage(Const.LINK_EDIT_MESSAGE);
                buttonLinkId = Integer.parseInt(buttId);
                waitingType = WaitingType.UPDATE_BUTTON_LINK;
                return EXIT;
            } else {
                return COMEBACK;
            }

        } else {
            return COMEBACK;
        }
        return EXIT;
    }

    private void clearOld() {
        deleteMessage(textId);
        deleteMessage(photoId);
    }

    private void loadElements() {
        if (currentButton.getMessageId() == null) {
            message = null;
        } else {
            message = messageRepo.findByIdAndLanguageId(currentButton.getMessageId(), currentLanguage.getId());
        }
    }

    private static int getMaxSizeMessage() {
        return Const.MAX_SIZE_MESSAGE;
    }

    private boolean isHasMessageForEdit() throws TelegramApiException {
        if (message == null) {
            sendMessage(Const.DOESNT_FOR_THIS_BUTTON);
            return COMEBACK;
        }
        return EXIT;
    }

    private void updatePhoto() {
        message.setPhoto(updateMessagePhoto);
        update();
    }

    private void update() {
        //messageRepo.save(message);
        messageDao.update(message);
        log.info("Update message {} for lang {} - chatId = ", message.getId(), currentLanguage.name(), chatId);
    }

    private void updateFile() {
        if (hasDocument()) {
            message.setFile(update.getMessage().getDocument().getFileId(), FileType.document);
        } else if (hasAudio()) {
            message.setFile(update.getMessage().getAudio().getFileId(), FileType.audio);
        } else if (hasVideo()) {
            message.setFile(update.getMessage().getVideo().getFileId(), FileType.video);
        } else if (hasPhoto()) {
            message.setFile(updateMessagePhoto, FileType.photo);
        }
        update();
    }

    private void deleteFile() {
        message.setFileType(null);
        message.setFile(null);
        update();
    }

    private boolean getButtonIds(int keyboardMarkUpId) {
        String buttonsString = keyboardMarkUpService.getButtonString(keyboardMarkUpId);
        if (buttonsString == null) return COMEBACK;
        String rows[] = buttonsString.split(";");
        for (String buttonIdString : rows) {
            String[] buttonIds = buttonIdString.split(",");
            for (String buttonId : buttonIds) {
                Button buttonFromDb = buttonRepo.findByIdAndLangId(Integer.parseInt(buttonId), currentLanguage.getId());
                String url = buttonFromDb.getUrl();
                if (url != null) {
                    return EXIT;
                } else {
                    return COMEBACK;
                }
            }
        }
        return COMEBACK;
    }
}
