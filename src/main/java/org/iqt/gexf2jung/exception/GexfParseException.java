/*
 * Copyright 2014 In-Q-Tel/Lab41.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.iqt.gexf2jung.exception;

/**
 * This represents a generic GEXF parsing exception. This should be overridden.
 * @author Avery Cowan
 */
public abstract class GexfParseException extends RuntimeException{

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
