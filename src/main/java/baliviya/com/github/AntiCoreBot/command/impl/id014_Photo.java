package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.enums.WaitingType;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class id014_Photo extends Command {

    @Override
    public boolean execute() throws TelegramApiException {
        switch (waitingType) {
            case START:
                deleteMessage(updateMessageId);
                sendMessage("Photo");
                waitingType = WaitingType.PHONE;
                return COMEBACK;
            case PHONE:
                deleteMessage(updateMessageId);
                if (hasPhoto()) sendMessage(updateMessagePhoto);
                if (hasDocument()) sendMessage(update.getMessage().getDocument().getFileId());
                return COMEBACK;
        }
        return EXIT;
    }
}
