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
package com.photowey.popcorn.common.clock;

import com.photowey.popcorn.common.constant.CommonConstants;
import com.photowey.popcorn.common.date.DatePatternConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

/**
 * {@code SystemClockTest}
 *
 * @author photowey
 * @date 2023/07/26
 * @since 1.0.0
 */
class SystemClockTest {

    @Test
    void testString_now() {
        String now = SystemClock.String.now();
        Assertions.assertNotNull(now);
    }

    @Test
    void testString_transfer() {
        LocalDateTime now = SystemClock.String.transfer("2023-07-26 22:25:30");
        Assertions.assertNotNull(now);
    }

    @Test
    void testString_transfer_pattern() {
        LocalDateTime now = SystemClock.String.transfer("20230726222530", DatePatternConstants.yyyyMMddHHmmss);
        Assertions.assertNotNull(now);
    }

    @Test
    void testTimestamp_now() {
        Long now = SystemClock.Timestamp.now();
        Assertions.assertNotNull(now);
    }

    @Test
    void testTimestamp_transfer() {
        Long ts = 1690381724000L;
        LocalDateTime now = SystemClock.Timestamp.transfer(ts);
        Assertions.assertNotNull(now);
    }

    @Test
    void testTimestamp_transfer_short() {
        Long ts = 1690381724L;
        LocalDateTime now = SystemClock.Timestamp.transferShort(ts);
        Assertions.assertNotNull(now);
    }

    @Test
    void testLocalDateTime_now() {
        LocalDateTime now = SystemClock.LocalDateTime.now();
        Assertions.assertNotNull(now);
    }

    @Test
    void testLocalDateTime_transfer() {
        Long now = SystemClock.LocalDateTime.transfer(LocalDateTime.now());
        Assertions.assertNotNull(now);
    }

    @Test
    void testLocalDateTime_transfers() {
        String now = SystemClock.LocalDateTime.transfers(LocalDateTime.now());
        Assertions.assertNotNull(now);
    }

    @Test
    void testLocalDateTime_transfers_pattern() {
        String now = SystemClock.LocalDateTime.transfers(LocalDateTime.now(), DatePatternConstants.yyyyMMddHHmmss);
        Assertions.assertNotNull(now);
        Assertions.assertFalse(now.contains(CommonConstants.SPACE_STRING));
    }
}