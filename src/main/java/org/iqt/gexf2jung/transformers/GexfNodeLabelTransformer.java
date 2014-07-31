/*
 * Copyright 2014 Avery Cowan.
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

package org.iqt.gexf2jung.transformers;

import org.apache.commons.collections15.Transformer;
import org.iqt.gexf2jung.Node;

/**
 *
 * @author Avery Cowan
 */
public class GexfNodeLabelTransformer implements Transformer<Node, String> {

    public String transform(Node n) {
        return n.getLabel();
    }
}