package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.model.custom.CitizensRegistration;
import baliviya.com.github.AntiCoreBot.model.custom.SendMember;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class id018_AcceptOrReject extends Command {
    @Override
    public boolean execute() throws TelegramApiException {
        deleteMessage(updateMessageId);
        SendMember sendMember = sendMemberRepo.findByChatId(chatId);
        CitizensRegistration citizensRegistration = citizensRegistrationRepo.findById(sendMember.getRegistrationId());
        if (isButton(1018)) citizensRegistration.setStatus("Подтвердил");
        if (isButton(1019)) citizensRegistration.setStatus("Отказался");
        citizensRegistrationRepo.save(citizensRegistration);
        return EXIT;
    }
}
