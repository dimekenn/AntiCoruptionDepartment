package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.model.custom.CitizensEmployee;
import baliviya.com.github.AntiCoreBot.model.custom.CitizensRegistration;
import baliviya.com.github.AntiCoreBot.model.custom.SendMember;
import baliviya.com.github.AntiCoreBot.model.standart.User;
import baliviya.com.github.AntiCoreBot.util.Const;
import baliviya.com.github.AntiCoreBot.util.DateUtil;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class id016__CitizenMember extends Command {

    String status = "Записан";

    @Override
    public boolean execute() throws TelegramApiException {
        if (!isCitizenEmployee()) {
            sendMessage(Const.NO_ACCESS);
            return EXIT;
        }
        switch (waitingType){
            case START:
                deleteMessage(updateMessageId);
                CitizensEmployee citizensEmployee = citizenEmployeeRepo.getByChatId(chatId);
                if (citizensRegistrationRepo.findAllByReceptionIdAndStatus(citizensEmployee.getReceptionId(), status) != null){
                    for (CitizensRegistration registration : citizensRegistrationRepo.findAllByReceptionIdAndStatus(citizensEmployee.getReceptionId(), status)) {
                        //CitizensRegistration registration = citizensRegistrationRepo.findByReceptionIdAndStatus(citizensEmployee.getReceptionId(), status);
                        //registration = citizensRegistrationRepo.findByReceptionIdAndStatus(citizensEmployee.getReceptionId(), status);
                        User user = usersRepo.getByChatId(registration.getChatId());
                        String result = String.format(getText(1052), user.getFullName(), receptionRepo.getById(registration.getReceptionId()).getName(), DateUtil.getDayDate(registration.getCitizensDate()), registration.getCitizensTime());
                        toDeleteKeyboard(sendMessageWithKeyboard(result, keyboardMarkUpDao.select(1010), user.getChatId()));
                        SendMember sendMember = new SendMember();
                        sendMember.setChatId(user.getChatId());
                        sendMember.setReceptionId(registration.getReceptionId());
                        sendMember.setRegistrationId(registration.getId());
                        sendMemberRepo.save(sendMember);
                    }
                    sendMessage("Напоминание отправлено");
                } else{
                    sendMessage("Зарегистрированых пользователей на прием нету");
                }
            return EXIT;
        }
        return EXIT;
    }
}
