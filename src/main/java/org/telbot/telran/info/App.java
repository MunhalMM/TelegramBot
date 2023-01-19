package org.telbot.telran.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.telbot.telran.info.configuration.BotConfiguration;

@SpringBootApplication
@Import(BotConfiguration.class)
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
