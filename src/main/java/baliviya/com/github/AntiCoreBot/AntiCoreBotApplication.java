package baliviya.com.github.AntiCoreBot;

import baliviya.com.github.AntiCoreBot.configuration.Bot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@SpringBootApplication
@Slf4j
public class AntiCoreBotApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AntiCoreBotApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ApiContextInitializer.init();
        log.info("ApiContextInitializer.InitNormal()");
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        Bot bot = new Bot();
        try {
            telegramBotsApi.registerBot(bot);
            log.info("Bot was registered: " + bot.getBotUsername());
        } catch (TelegramApiRequestException e) {
            log.error("Error in main class", e);
        }
    }
}
