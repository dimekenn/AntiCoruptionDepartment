package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.enums.Language;
import baliviya.com.github.AntiCoreBot.enums.WaitingType;
import baliviya.com.github.AntiCoreBot.model.custom.AppealType;
import baliviya.com.github.AntiCoreBot.model.custom.Employee;
import baliviya.com.github.AntiCoreBot.util.Const;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class id012_EditAppeal extends Command {

    private List<AppealType> typeList;
    private List<Employee> employees;
    private AppealType appealType;
    private int deleteMessageId;
    private int appealTypeId;
    private Language currentLanguage = Language.ru;

    @Override
    public boolean execute() throws TelegramApiException {
        if (!isAdmin()) {
            sendMessage(Const.NO_ACCESS);
            return EXIT;
        }
        switch (waitingType) {
            case START:
                deleteMessage(updateMessageId);
                sendListCategory();
                waitingType = WaitingType.CHOOSE_CATEGORY;
                return COMEBACK;
            case CHOOSE_CATEGORY:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (hasMessageText()) {
                    if (isCommand("/em")) {
                        appealType = typeList.get(getInt());
                        sendInfo();
                        waitingType = WaitingType.EDITION;
                    } else if (isCommand("/new")) {
                        deleteMessageId = sendMessage("Введите название для новой категорий");
                        waitingType = WaitingType.NEW_CATEGORY;
                        return COMEBACK;
                    } else if (isCommand("/st")) {
                        appealType = typeList.get(getInt());
                        sendCategoryInfo();
                        waitingType = WaitingType.EDITION;
                    }
                }
                return COMEBACK;
            case EDITION:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (hasMessageText()) {
                    if (isCommand("/back")) {
                        sendListCategory();
                        waitingType = WaitingType.CHOOSE_CATEGORY;
                    } else if (isCommand("/del")) {
                        int numberEmployee = Integer.parseInt(updateMessageText.replaceAll("[^0-9]", ""));
                        employeeRepo.delete(employees.get(numberEmployee));
                        sendInfo();
                        waitingType = WaitingType.EDITION;
                    } else if (isCommand("/drop")) {
                        appealTypeDao.delete(appealType.getId());
                        sendListCategory();
                        waitingType = WaitingType.CHOOSE_CATEGORY;
                    } else if (isCommand("/edit")) {
                        deleteMessageId = sendMessage("Введите название для категорий");
                        waitingType = WaitingType.UPDATE_CATEGORY;
                    } else if (isCommand("/swap")) {
                        changeLanguage();
                    }
                }
                if (hasContact()) registerNewEmployee();
                return COMEBACK;
            case NEW_CATEGORY:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (hasMessageText()) {
                    appealType = new AppealType();
                    appealType.setName(updateMessageText);
                    appealType.setLangId(Language.ru.getId());
                    appealTypeId = appealTypeDao.insert(appealType);
                    deleteMessageId = sendMessage("Введите казахское название для новой категорий");
                    waitingType = WaitingType.NEW_KZ_CATEGORY;
                }
                return COMEBACK;
            case NEW_KZ_CATEGORY:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (hasMessageText()) {
                    appealType = new AppealType();
                    appealType.setId(appealTypeId);
                    appealType.setName(updateMessageText);
                    appealType.setLangId(Language.kz.getId());
                    appealTypeDao.insertWithId(appealType);
                    deleteMessageId = sendMessage("Введите английское название для новой категорий");
                    waitingType = WaitingType.NEW_EN_CATEGORY;
                }
                return COMEBACK;
            case NEW_EN_CATEGORY:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (hasMessageText()) {
                    appealType = new AppealType();
                    appealType.setId(appealTypeId);
                    appealType.setName(updateMessageText);
                    appealType.setLangId(Language.en.getId());
                    appealTypeDao.insertWithId(appealType);
                    sendListCategory();
                    waitingType = WaitingType.CHOOSE_CATEGORY;
                }
                return COMEBACK;
            case UPDATE_CATEGORY:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (hasMessageText()) {
                    appealType.setName(updateMessageText);
                    appealTypeDao.update(appealType);
                    sendCategoryInfo();
                    waitingType = WaitingType.EDITION;
                }
                return COMEBACK;
        }
        return EXIT;
    }

    private void sendListCategory() throws TelegramApiException {
        String formatMassage = getText(Const.CATEGORY_LIST_MESSAGE);
        StringBuilder infoByEmployee = new StringBuilder();
        typeList = appealTypeRepo.findAllByLangId(currentLanguage.getId());
        String format = getText(Const.CATEGORY_EDIT_MESSAGE);
        for (int i = 0; i < typeList.size(); i++) {
            infoByEmployee.append(String.format(format, "/em" + i, "/st" + i, typeList.get(i).getName())).append(next);
        }
        deleteMessageId = sendMessage(String.format(formatMassage, infoByEmployee.toString(), "/new"));
    }

    private void sendInfo() throws TelegramApiException {
        String formatMessage = getText(Const.ABOUT_CATEGORY_MESSAGE);
        StringBuilder listEmployeeSB = new StringBuilder();
        employees = employeeRepo.findAllByHandling(appealType.getId());
        int count = 0;
        if (employees != null) {
            for (Employee employee : employees) {
                listEmployeeSB.append("/del").append(count).append("❌").append(" - \uD83D\uDD0E ").append(getLinkForUser(employee.getEmployeeId(), usersRepo.getByChatId(employee.getEmployeeId()).getUsername())).append(next);
                count++;
            }
        }
        String result = String.format(formatMessage, appealType.getName() + " ", listEmployeeSB.toString(), "Чтобы добавить нового ответственного, отправьте контакт пользователя. Он должен быть зарегистрированным.", "/back");
        deleteMessageId = sendMessage(result);
    }

    private boolean registerNewEmployee() throws TelegramApiException {
        long newEmployeeChatId = update.getMessage().getContact().getUserID();
        if (!isUser(newEmployeeChatId)) {
            sendMessage(Const.USER_DO_NOT_REGISTERED);
            sendInfo();
            waitingType = WaitingType.EDITION;
        } else {
            if (isEmployee(newEmployeeChatId, appealType.getId())) {
                sendMessage("Пользователь уже ответственный");
            } else {
                employeeRepo.save(new Employee().setEmployeeId(newEmployeeChatId).setHandling(appealType.getId()));
            }
            sendInfo();
            waitingType = WaitingType.EDITION;
        }
        return COMEBACK;
    }

    private void sendCategoryInfo() throws TelegramApiException {
        String formatMessage = getText(Const.EDIT_CATEGORY_MESSAGE);
        String languageInfo;
        if (appealType.getLangId() == 1) {
            languageInfo = "\uD83C\uDDF7\uD83C\uDDFA ru";
        } else if (appealType.getLangId() == 2) {
            languageInfo = "\uD83C\uDDF0\uD83C\uDDFF kz";
        } else {
            languageInfo = "\uD83C\uDFF3️\u200D\uD83C\uDF08 en";
        }
        deleteMessageId = sendMessage(String.format(formatMessage, appealType.getName(), languageInfo, "/swap", "/edit", "/drop", "/back"));
    }

    private void changeLanguage() throws TelegramApiException {
        if (currentLanguage == Language.ru) {
            currentLanguage = Language.kz;
        } else if (currentLanguage == Language.kz) {
            currentLanguage = Language.en;
        } else {
            currentLanguage = Language.ru;
        }
        appealType = appealTypeRepo.findByIdAndLangId(appealType.getId(), currentLanguage.getId());
        sendCategoryInfo();
        waitingType = WaitingType.EDITION;
    }

    private int getInt() {
        return Integer.parseInt(updateMessageText.replaceAll("[^0-9]", ""));
    }

    private boolean isCommand(String command) {
        return updateMessageText.startsWith(command);
    }
}
