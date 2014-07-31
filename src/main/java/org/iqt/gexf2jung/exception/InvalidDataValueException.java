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
 * This Exception is to be called if a required data value is invalid such as class in attributes.
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
     * specified detail message. This should include the name of the tag that has an invalid value and the invalid value itself.
     *
     * @param msg the detail message.
     */
    public InvalidDataValueException(String msg) {
        super(msg);
    }
}
