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
package com.photowey.popcorn.app.core.task;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Map;

/**
 * {@code RequestTaskDecorator}
 *
 * @author photowey
 * @date 2023/07/08
 * @since 1.0.0
 */
public class RequestTaskDecorator implements TaskDecorator {

    @Override
    public Runnable decorate(Runnable runnable) {
        Map<String, String> ctx = MDC.getCopyOfContextMap();
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return () -> {
            try {
                if (this.isNotEmpty(ctx)) {
                    MDC.setContextMap(ctx);
                }
                if (this.isNotEmpty(requestAttributes)) {
                    RequestContextHolder.setRequestAttributes(requestAttributes);
                }
                runnable.run();
            } finally {
                if (this.isNotEmpty(ctx)) {
                    MDC.clear();
                }
                if (this.isNotEmpty(requestAttributes)) {
                    RequestContextHolder.resetRequestAttributes();
                }
            }
        };
    }

    private <T> boolean isNotEmpty(T target) {
        return !ObjectUtils.isEmpty(target);
    }
}
