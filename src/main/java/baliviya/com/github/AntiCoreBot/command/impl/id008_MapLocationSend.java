package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.model.standart.Properties;
import baliviya.com.github.AntiCoreBot.repository.PropertiesRepo;
import baliviya.com.github.AntiCoreBot.repository.TelegramBotRepositoryProvider;
import baliviya.com.github.AntiCoreBot.util.Const;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class id008_MapLocationSend extends Command {

    private PropertiesRepo propertiesRepo = TelegramBotRepositoryProvider.getPropertiesRepo();

    @Override
    public boolean execute() throws TelegramApiException {
        Properties properties       = propertiesRepo.findById(Const.LOCATION).get();
        SendLocation sendLocation   = new SendLocation();
        sendLocation.setLatitude(Float.parseFloat(properties.getLatitude()));
        sendLocation.setLongitude(Float.parseFloat(properties.getLongitude()));
        bot.execute(sendLocation.setChatId(chatId));
        return EXIT;
    }
}
