package org.telbot.telran.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telbot.telran.info.configuration.BotConfiguration;
import org.telbot.telran.info.service.TelegramBot;

import java.util.Arrays;

@SpringBootApplication
@Import(BotConfiguration.class)
@EnableScheduling
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
