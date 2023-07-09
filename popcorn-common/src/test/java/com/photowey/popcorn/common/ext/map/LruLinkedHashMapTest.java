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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@code LruLinkedHashMapTest}
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
class LruLinkedHashMapTest {

    @Test
    void testLRU() {
        LruLinkedHashMap<Long, Long> map = Maps.newLruLinkedHashMap(1 << 3);

        for (long i = 0; i < 10; i++) {
            if (i > 0 && 4 % i == 0) {
                map.get(1L);
            }

            map.put(i, i);
        }

        Assertions.assertEquals(8, map.size());
        Assertions.assertEquals(8L, map.get(8L));

        map.forEach((k, v) -> System.out.printf("key: %d -> value: %d%n", k, v));

        Assertions.assertNull(map.get(2L));
    }
}