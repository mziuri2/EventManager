/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.eventmanager.exception;

/**
 *
 * @author USER
 */
public class SQLException extends Exception {

    /**
     * Creates a new instance of <code>SQLException</code> without detail
     * message.
     */
    public SQLException() {
    }

    /**
     * Constructs an instance of <code>SQLException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SQLException(String msg) {
        super(msg);
    }
}
