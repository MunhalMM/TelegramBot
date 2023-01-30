package org.telbot.telran.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telbot.telran.info.configuration.BotConfiguration;

/**
 * This is main class for running the program
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
@SpringBootApplication
@Import(BotConfiguration.class)
@EnableScheduling
public class App {
    /**
     * This is method main,where start point of the program
     *
     * @param args command line values
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
