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
public class GexfParseException extends RuntimeException{

    /**
     * Creates a new instance of <code>GefxParseException</code> without detail
     * message.
     */
    public GexfParseException() {
    }

    /**
     * Constructs an instance of <code>GefxParseException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public GexfParseException(String msg) {
        super(msg);
    }
}
