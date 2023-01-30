package org.telbot.telran.info.configuration;

/**
 * This is abstract class enum with name BotRole,where i am describe the ADMIN/USER role for users
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
public enum BotRole {

    /**
     * Enum fields initialization
     */
    ADMIN("Administrator"),
    USER("User");
    /**
     * String field for description enum fields name
     */
    private String name;

    /**
     * This is constructor for initialization enum BotRole
     *
     * @param name field values
     */
    BotRole(String name) {
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