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

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@code LruLinkedHashMap}
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
public class LruLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int limited;

    public LruLinkedHashMap() {
        super();
    }

    public LruLinkedHashMap(int initialCapacity) {
        super(initialCapacity);
    }

    public LruLinkedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public LruLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    public LruLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder, int limited) {
        super(initialCapacity, loadFactor, accessOrder);
        this.limited = limited;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > limited;
    }
}
