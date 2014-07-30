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
public class MissingDataValueException extends GexfParseException {

    /**
     * Creates a new instance of <code>MissingDataValue</code> without detail
     * message.
     */
    public MissingDataValueException() {
    }

    /**
     * Constructs an instance of <code>MissingDataValue</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MissingDataValueException(String msg) {
        super(msg);
    }
    public MissingDataValueException(String tag, String qname){
        this("A <"+tag+"> tag is missing a value for type "+qname+".");
    }
}
