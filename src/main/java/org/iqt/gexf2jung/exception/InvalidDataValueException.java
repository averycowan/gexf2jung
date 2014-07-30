/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.iqt.gexf2jung.exception;

/**
 *
 * @author Avery Cowan
 */
public class InvalidDataValueException extends GexfParseException {

    /**
     * Creates a new instance of <code>InvalidDataValueException</code> without
     * detail message.
     */
    public InvalidDataValueException() {
    }

    /**
     * Constructs an instance of <code>InvalidDataValueException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidDataValueException(String msg) {
        super(msg);
    }
}
