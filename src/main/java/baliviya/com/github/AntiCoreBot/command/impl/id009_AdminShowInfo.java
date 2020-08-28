package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.util.Const;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class id009_AdminShowInfo extends Command {

    @Override
    public boolean execute() throws TelegramApiException {
        if (!isAdmin()) {
            sendMessage(Const.NO_ACCESS);
            return EXIT;
        }
        sendMessageWithAddition();
        return EXIT;
    }
}
