package org.telbot.telran.info.service;

/**
 * This is an interface for abstracting business logic to the start/stop command
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
public interface CommandService {
    /**
     * This abstract method for executing start/stop command
     *
     * @param command       string command and interface Switchable with variable switchablebot
     * @param switchableBot variable for interface Switchable and string command
     * @see Switchable interface
     */
    void executeCommand(String command, Switchable switchableBot);
}
