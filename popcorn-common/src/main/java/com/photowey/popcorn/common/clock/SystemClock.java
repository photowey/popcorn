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

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * {@code SystemClock}
 *
 * @author photowey
 * @date 2023/07/26
 * @since 1.0.0
 */
public enum SystemClock {

    ;

    public enum String {

        ;

        public static java.lang.String now() {
            return formatter().format(java.time.LocalDateTime.now());
        }

        public static java.time.LocalDateTime transfer(java.lang.String dateTime) {
            return transfer(dateTime, DatePatternConstants.yyyy_MM_dd_HH_mm_ss);
        }

        public static java.time.LocalDateTime transfer(java.lang.String dateTime, java.lang.String pattern) {
            if (isBlank(dateTime)) {
                return null;
            }

            return java.time.LocalDateTime.parse(dateTime, formatter(pattern));
        }
    }

    public enum Timestamp {

        ;

        public static long now() {
            return System.currentTimeMillis() / CommonConstants.MILLIS_UNIT * CommonConstants.MILLIS_UNIT;
        }

        public static java.time.LocalDateTime transfer(Long ts) {
            if (null == ts || 0L == ts) {
                return null;
            }
            if (java.lang.String.valueOf(ts).length() < CommonConstants.TIME_STAMP_LENGTH) {
                return transferShort(ts);
            }

            return java.time.LocalDateTime.ofInstant(Instant.ofEpochMilli(ts), ZoneId.systemDefault());
        }

        public static java.time.LocalDateTime transferShort(Long ts) {
            if (null == ts || 0L == ts) {
                return null;
            }
            if (java.lang.String.valueOf(ts).length() >= CommonConstants.TIME_STAMP_LENGTH) {
                return transfer(ts);
            }

            return transfer(ts * CommonConstants.MILLIS_UNIT);
        }
    }

    public enum LocalDateTime {

        ;

        public static java.time.LocalDateTime now() {
            return java.time.LocalDateTime.now();
        }

        public static Long transfer(java.time.LocalDateTime dateTime) {
            if (null == dateTime) {
                return null;
            }

            return trimTail(dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        }

        public static java.lang.String transfers(java.time.LocalDateTime dateTime) {
            return transfers(dateTime, DatePatternConstants.yyyy_MM_dd_HH_mm_ss);
        }

        public static java.lang.String transfers(java.time.LocalDateTime dateTime, java.lang.String pattern) {
            return format(dateTime, pattern);
        }
    }

    // ------------------------------------------------

    public static boolean isBlank(java.lang.String txt) {
        return null == txt || txt.trim().length() == 0;
    }

    public static boolean isNotBlank(java.lang.String txt) {
        return !isBlank(txt);
    }

    // ------------------------------------------------ format

    public static java.lang.String format(java.time.LocalDateTime dateTime) {
        return format(dateTime, DatePatternConstants.yyyy_MM_dd_HH_mm_ss);
    }

    public static java.lang.String format(java.time.LocalDateTime dateTime, java.lang.String pattern) {
        if (null == dateTime) {
            return null;
        }

        DateTimeFormatter formatter = formatter(pattern);
        return formatter.format(dateTime);
    }

    // ------------------------------------------------ formatter

    public static DateTimeFormatter formatter() {
        return formatter(DatePatternConstants.yyyy_MM_dd_HH_mm_ss);
    }

    public static DateTimeFormatter formatter(java.lang.String pattern) {
        pattern = isNotBlank(pattern) ? pattern : DatePatternConstants.yyyy_MM_dd_HH_mm_ss;

        return DateTimeFormatter.ofPattern(pattern);
    }

    // ------------------------------------------------

    public static long trimTail(long ts) {
        return ts / CommonConstants.MILLIS_UNIT * CommonConstants.MILLIS_UNIT;
    }
}
