package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.model.standart.Admin;
import baliviya.com.github.AntiCoreBot.model.standart.User;
import baliviya.com.github.AntiCoreBot.util.Const;
import baliviya.com.github.AntiCoreBot.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Date;
import java.util.List;

@Slf4j
public class id011_EditAdmin extends Command {

    private static String delete;
    private static String deleteIcon;
    private static String showIcon;
    private int messageId;
    private StringBuilder text;
    private List<Admin> allAdmins;

    @Override
    public boolean execute() throws TelegramApiException {
        deleteMessage(updateMessageId);
        if (!isAdmin()) {
            sendMessage(Const.NO_ACCESS);
            return EXIT;
        }
        if (deleteIcon == null) {
            deleteIcon = getText(Const.ICON_CROSS);
            showIcon = getText(Const.ICON_LOUPE);
            delete = getText(Const.DELETE_BUTTON_SLASH);
        }
        if (messageId != 0) deleteMessage(messageId);
        if (hasContact()) {
            registerNewAdmin();
            return COMEBACK;
        }
        if (updateMessageText.contains(delete)) {
            if (allAdmins.size() > 1) {
                int numberAdminList = Integer.parseInt(updateMessageText.replaceAll("[^0-9]", ""));
                adminRepo.delete(allAdmins.get(numberAdminList));
            }
        }
        sendEditorAdmin();
        return COMEBACK;
    }

    private boolean registerNewAdmin() throws TelegramApiException {
        long newAdminChatId = update.getMessage().getContact().getUserID();
        if (!isUser(newAdminChatId)) {
            sendMessage(Const.USER_DO_NOT_REGISTERED);
            return EXIT;
        } else {
            if (isAdmin(newAdminChatId)) {
                sendMessage(Const.USER_IS_ADMIN);
                return EXIT;
            } else {
                User user = usersRepo.getByChatId(newAdminChatId);
                adminRepo.save(new Admin().setChatId(newAdminChatId).setComment(String.format("%s %s %s", user.getFullName(), user.getPhone(), DateUtil.getDbMmYyyyHhMmSs(new Date()))));
                User userAdmin = usersRepo.getByChatId(chatId);
                log.info("{} added new admin - {} ", getInfoByUser(userAdmin), getInfoByUser(user));
                sendEditorAdmin();
            }
        }

        return COMEBACK;
    }

    private void getText(boolean withLink) {
        text = new StringBuilder();
        allAdmins = adminRepo.findAll();
        int count = 0;
        for (Admin admin : allAdmins) {
            try {
                User user = usersRepo.getByChatId(admin.getChatId());
                if (allAdmins.size() == 1) {
                    if (withLink) {
                        text.append(getLinkForUser(admin.getChatId(), user.getUsername())).append(space).append(next);
                    } else {
                        text.append(getInfoByUser(user)).append(space).append(next);
                    }
                    text.append(getText(Const.WARNING_INFO_ABOUT_ADMIN)).append(next);
                    count++;
                } else {
                    if (withLink) {
                        text.append(delete).append(count).append(deleteIcon).append(" - ").append(showIcon).append(getLinkForUser(user.getChatId(), user.getUsername())).append(space).append(next);
                    } else {
                        text.append(delete).append(count).append(deleteIcon).append(" - ").append(getInfoByUser(user)).append(space).append(next);
                    }
                    count++;
                }
            } catch (Exception e) {
                log.error("Error in EditAdmin ", e);
            }
        }

//        allAdmins.forEach(admin -> {
//            if (allAdmins.size() == 1) {
//                if (withLink) {
//                    text.append(getLinkForUser(admin.getChatId(), usersRepo.getByChatId(admin.getChatId()).getUsername())).append(space).append(next);
//                } else {
//                    text.append(getInfoByUser(usersRepo.getByChatId(admin.getChatId()))).append(space).append(next);
//                }
//                text.append(getText(Const.WARNING_INFO_ABOUT_ADMIN)).append(next);
//                count++;
//            }
//        });
    }

    private void sendEditorAdmin() throws TelegramApiException {
        deleteMessage(updateMessageId);
        try {
            getText(true);
            messageId = sendMessage(String.format(getText(Const.ADMIN_SHOW_LIST), text.toString()));
        } catch (TelegramApiException e) {
            getText(false);
            messageId = sendMessage(String.format(getText(Const.ADMIN_SHOW_LIST), text.toString()));
        }
        toDeleteMessage(messageId);
    }

    private String getInfoByUser(User user) {
        return String.format("%s %s %s", user.getFullName(), user.getPhone(), user.getChatId());
    }
}
