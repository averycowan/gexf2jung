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
public class NoAttributeClassException extends GexfParseException {

    /**
     * Creates a new instance of <code>NoAttributeClassDefined</code> without
     * detail message.
     */
    public NoAttributeClassException() {
    }

    /**
     * Constructs an instance of <code>NoAttributeClassDefined</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoAttributeClassException(String msg) {
        super(msg);
    }
}
