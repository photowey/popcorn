/*
 * Copyright © 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.photowey.popcorn.common.ext.map;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * {@code LimitedTreeMap}
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
public class LimitedTreeMap<K, V> extends TreeMap<K, V> {

    public V headFirst(K k) {
        SortedMap<K, V> headMap = this.headMap(k);
        if (!headMap.isEmpty()) {
            return headMap.get(headMap.firstKey());
        }

        return this.firstEntry().getValue();
    }

    public V headLast(K k) {
        SortedMap<K, V> headMap = this.headMap(k);
        if (!headMap.isEmpty()) {
            return headMap.get(headMap.lastKey());
        }

        return this.lastEntry().getValue();
    }

    public V tailFirst(K k) {
        SortedMap<K, V> tailMap = this.tailMap(k);
        if (!tailMap.isEmpty()) {
            return tailMap.get(tailMap.firstKey());
        }

        return this.firstEntry().getValue();
    }

    public V tailLast(K k) {
        SortedMap<K, V> tailMap = this.tailMap(k);
        if (!tailMap.isEmpty()) {
            return tailMap.get(tailMap.lastKey());
        }

        return this.lastEntry().getValue();
    }

}
