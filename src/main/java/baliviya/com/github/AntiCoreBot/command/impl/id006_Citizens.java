package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.enums.WaitingType;
import baliviya.com.github.AntiCoreBot.model.custom.CitizensRegistration;
import baliviya.com.github.AntiCoreBot.model.custom.Reception;
import baliviya.com.github.AntiCoreBot.repository.CitizensInfoRepo;
import baliviya.com.github.AntiCoreBot.repository.CitizensRegistrationRepo;
import baliviya.com.github.AntiCoreBot.repository.TelegramBotRepositoryProvider;
import baliviya.com.github.AntiCoreBot.util.ButtonsLeaf;
import baliviya.com.github.AntiCoreBot.util.Const;
import baliviya.com.github.AntiCoreBot.util.DateUtil;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class id006_Citizens extends Command {

    private List<Reception> receptions;
    private List<String> list;
    private ButtonsLeaf buttonsLeaf;
    private CitizensRegistration citizensRegistration;
    private CitizensInfoRepo citizensInfoRepo = TelegramBotRepositoryProvider.getCitizensInfoRepo();
    private CitizensRegistrationRepo citizensRegistrationRepo = TelegramBotRepositoryProvider.getCitizensRegistrationRepo();
    private int deleteMessageId;

    @Override
    public boolean execute() throws TelegramApiException {
        deleteMessage(updateMessageId);
        switch (waitingType) {
            case START:
                receptions = receptionRepo.findAllByLangId(getLanguage().getId());
                list = new ArrayList<>();
                receptions.forEach(reception -> list.add(reception.getName()));
                buttonsLeaf = new ButtonsLeaf(list);
                toDeleteKeyboard(sendMessageWithKeyboard(getText(Const.CHOOSE_RECEPTION_MESSAGE), buttonsLeaf.getListButton()));
                waitingType = WaitingType.CHOISE_RECEPTION;
                return COMEBACK;
            case CHOISE_RECEPTION:
                deleteMessage(updateMessageId);
                if (hasCallbackQuery()) {
                    int receptionId = receptions.get(Integer.parseInt(updateMessageText)).getId();
                    citizensRegistration = new CitizensRegistration();
                    citizensRegistration.setChatId(chatId);
                    citizensRegistration.setReceptionId(receptionId);
                    citizensRegistration.setStatus("Записан");
                    citizensRegistration.setCitizensDate(citizensInfoRepo.findById(receptionId).map(citizensInfo -> citizensInfo.getDate()).orElse(null));
                    citizensRegistration.setCitizensTime(citizensInfoRepo.findById(receptionId).map(citizensInfo -> citizensInfo.getTime()).orElse(null));
                    deleteMessageId = getName();
                    waitingType = WaitingType.SET_FULL_NAME;
                }
                return COMEBACK;
            case SET_FULL_NAME:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (hasMessageText()) {
                    citizensRegistration.setFullName(updateMessageText);
                    deleteMessageId = getQuest();
                    waitingType = WaitingType.SET_QUESTION;
                }
                return COMEBACK;
            case SET_QUESTION:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (hasMessageText()) {
                    citizensRegistration.setQuestion(updateMessageText);
                    toDeleteKeyboard(sendMessageWithKeyboard(getText(Const.PRESS_BUTTON_INSERT_MESSAGE), Const.SIGN_UP_BUTTON_KEYBOARD));
                    waitingType = WaitingType.WAIT;
                }
                return COMEBACK;
            case WAIT:
                deleteMessage(updateMessageId);
                if (isButton(Const.SIGN_UP_BUTTON)) {
                    citizensRegistration.setDate(new Date());
                    citizensRegistrationRepo.save(citizensRegistration);
                    sendMessageToEmployee();
                    sendMessage(String.format(getText(Const.CITIZENS_DONE_SUCCESS_MESSAGE), citizensRegistration.getFullName(), receptionRepo.findByIdAndLangId(citizensRegistration.getReceptionId(), getLanguage().getId()).getName()));
                    return EXIT;
                }
                return COMEBACK;
        }
        return EXIT;
    }

    private int getName() throws TelegramApiException {
        return botUtils.sendMessage(Const.SET_FULL_NAME_MESSAGE, chatId);
    }

    private int getQuest() throws TelegramApiException {
        return botUtils.sendMessage(Const.QUEST_TEXT_FROM_CITIZENS_MESSAGE, chatId);
    }

    private void sendMessageToEmployee() throws TelegramApiException {
        StringBuilder sb = new StringBuilder();
        sb.append("Новая запись №" + citizensRegistration.getId()).append(next);
        sb.append("ФИО : " + citizensRegistration.getFullName()).append(next);
        sb.append("Текст обращение: " + citizensRegistration.getQuestion()).append(next);
        sb.append("Дата: " + DateUtil.getDayDate(citizensRegistration.getCitizensDate()) +" "+ citizensRegistration.getCitizensTime());
        sendMessage(sb.toString(), citizenEmployeeRepo.findByReceptionId(citizensRegistration.getReceptionId()).getChatId());
    }
}
