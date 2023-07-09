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
package com.photowey.popcorn.core.formatter.text;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/**
 * {@code StringFormatter}
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
public interface StringFormatter {

    /**
     * Format text.
     *
     * @param template the template of text.
     * @param args     the args of template.
     * @return formatted text.
     * @see FormattingTuple
     * @see MessageFormatter#arrayFormat(String, Object[])
     * @see FormattingTuple#getMessage()
     */
    static String format(String template, Object... args) {
        assert null != template;
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(template, args);
        return formattingTuple.getMessage();
    }
}
