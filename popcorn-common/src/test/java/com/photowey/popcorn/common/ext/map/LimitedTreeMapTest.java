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
 * {@code LimitedTreeMapTest}
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
class LimitedTreeMapTest {

    @Test
    void testHeadFirst() {
        LimitedTreeMap<Long, String> treeMap = Maps.newLimitedTreeMap();
        treeMap.put(20L, "20");
        treeMap.put(10L, "10");
        treeMap.put(30L, "30");
        treeMap.put(40L, "40");
        treeMap.put(60L, "60");
        treeMap.put(50L, "50");

        Long key = 40L;

        String headFirst = treeMap.headFirst(key);
        String headLast = treeMap.headLast(key);
        String tailFirst = treeMap.tailFirst(key);
        String tailLast = treeMap.tailLast(key);

        Assertions.assertEquals("10", headFirst);
        Assertions.assertEquals("30", headLast);
        Assertions.assertEquals("40", tailFirst);
        Assertions.assertEquals("60", tailLast);
    }

}