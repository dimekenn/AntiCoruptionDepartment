package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.enums.Language;
import baliviya.com.github.AntiCoreBot.service.LanguageService;
import baliviya.com.github.AntiCoreBot.util.Const;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class id003_SelectionLanguage extends Command {

    @Override
    public  boolean execute() throws TelegramApiException {
        deleteMessage(updateMessageId);
        chosenLanguage();
        toDeleteMessage(sendMessage(Const.WELCOME_TEXT_WHEN_START));
        return EXIT;
    }

    private void    chosenLanguage() {
        if (isButton(Const.RU_LANGUAGE)) LanguageService.setLanguage(chatId, Language.ru);
        if (isButton(Const.KZ_LANGUAGE)) LanguageService.setLanguage(chatId, Language.kz);
        if (isButton(Const.EN_LANGUAGE)) LanguageService.setLanguage(chatId, Language.en);
    }
}
