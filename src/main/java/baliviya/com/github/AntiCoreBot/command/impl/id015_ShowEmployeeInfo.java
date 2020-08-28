package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.model.standart.Message;
import baliviya.com.github.AntiCoreBot.util.Const;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.sql.SQLException;

public class id015_ShowEmployeeInfo extends Command {

    @Override
    public boolean execute() throws TelegramApiException {
        if (!isCitizenEmployee()) {
            sendMessage(Const.NO_ACCESS);
            return EXIT;
        }
        sendMessageWithAddition();
        return EXIT;
    }
}
