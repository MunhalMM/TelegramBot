package org.telbot.telran.info.service;

import org.springframework.stereotype.Service;
import org.telbot.telran.info.commands.Command;

/**
 * This class to implement the business logic interface Command for bots start stop function
 *
 * @author Munhal Mammadov
 * @version 1.0
 * @see CommandService
 */
@Service
public class CommandServiceImpl implements CommandService {
    /**
     * This method implements the passed command start or stop
     *
     * @param command       string command and interface Switchable with variable switchablebot
     * @param switchableBot variable for interface Switchable and string command
     */
    @Override
    public void executeCommand(String command, Switchable switchableBot) {
        if (Command.START.getName().equals(command)) {
            switchableBot.on();
        }
        if (Command.STOP.getName().equals(command)) {
            switchableBot.off();
        }
    }
}
