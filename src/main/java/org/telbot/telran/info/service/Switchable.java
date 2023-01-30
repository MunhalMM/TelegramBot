package org.telbot.telran.info.service;

/**
 * This is interface for function on/off
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
public interface Switchable {
    /**
     * THis is abstract method for on function
     */
    void on();

    /**
     * THis is abstract method for off function
     */
    void off();
}
