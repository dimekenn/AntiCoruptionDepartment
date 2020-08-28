package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.service.RegistrationService;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class id002_Registration extends Command {

    private RegistrationService registrationService = new RegistrationService();

    @Override
    public boolean execute() throws TelegramApiException {
        deleteMessage(updateMessageId);
        if (!isRegistered()) {
            if (!registrationService.isRegistration(update, botUtils)) {
                return COMEBACK;
            } else {
                usersRepo.save(registrationService.getUser());
                sendMessageWithAddition();
            }
        } else {
            sendMessageWithAddition();
        }
        return EXIT;
    }
}
