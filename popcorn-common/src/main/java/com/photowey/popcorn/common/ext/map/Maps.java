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

import com.photowey.popcorn.common.thrower.AssertionErrorThrower;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * {@code Maps}
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
public final class Maps {

    private Maps() {
        AssertionErrorThrower.throwz(Maps.class);
    }

    public static <K, V> Map<K, V> newHashMap() {
        return new HashMap<>(1 << 4);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static <K extends Comparable<K>, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap<>();
    }

    // ---------------------------------------------------------------- Ext

    public static <K, V> LruLinkedHashMap<K, V> newLruLinkedHashMap() {
        return newLruLinkedHashMap(1 << 10);
    }

    public static <K, V> LruLinkedHashMap<K, V> newLruLinkedHashMap(int limited) {
        return newLruLinkedHashMap(1 << 4, limited);
    }

    public static <K, V> LruLinkedHashMap<K, V> newLruLinkedHashMap(int initialCapacity, int limited) {
        return newLruLinkedHashMap(initialCapacity, 0.75F, limited);
    }

    public static <K, V> LruLinkedHashMap<K, V> newLruLinkedHashMap(int initialCapacity, float loadFactor, int limited) {
        return newLruLinkedHashMap(initialCapacity, loadFactor, true, limited);
    }

    public static <K, V> LruLinkedHashMap<K, V> newLruLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder, int limited) {
        return new LruLinkedHashMap<>(initialCapacity, loadFactor, accessOrder, limited);
    }

    public static <K extends Comparable<K>, V> LimitedTreeMap<K, V> newLimitedTreeMap() {
        return new LimitedTreeMap<>();
    }
}
