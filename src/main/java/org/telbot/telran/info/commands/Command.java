package org.telbot.telran.info.commands;

/**
 * This is abstract class enum with name Command,where i am describe the start/stop function
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
public enum Command {
    /**
     * Enum fields initialization
     */
    START("/start"),
    STOP("/stop");
    /**
     * String field for description enum fields name
     */
    private String name;

    /**
     * This is constructor for initialization enum Command
     *
     * @param name field values
     */
    Command(String name) {
        this.name = name;
    }

    /**
     * This is public method for return enum name
     *
     * @return String field name
     */
    public String getName() {
        return name;
    }
}
