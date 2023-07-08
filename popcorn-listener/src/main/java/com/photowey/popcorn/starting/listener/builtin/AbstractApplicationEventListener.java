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
package com.photowey.popcorn.starting.listener.builtin;

import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationEvent;

/**
 * {@code AbstractApplicationEventListener}
 *
 * @author photowey
 * @date 2023/07/08
 * @since 1.0.0
 */
public abstract class AbstractApplicationEventListener extends AbstractCommonApplicationEventListener {

    /**
     * Default supported event.
     */
    protected static final Class<?>[] EVENT_TYPES = {
            ApplicationStartingEvent.class,
            ApplicationEnvironmentPreparedEvent.class,
            ApplicationContextInitializedEvent.class,
            ApplicationPreparedEvent.class,
            ApplicationStartedEvent.class,
            ApplicationReadyEvent.class,
    };

    /**
     * Handle the event {@link ApplicationEvent}
     *
     * @param event {@link ApplicationEvent}
     */
    public abstract void onEvent(ApplicationEvent event);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        try {
            if (this.supports(applicationEvent)) {
                this.onEvent(applicationEvent);
            }
        } catch (Throwable tw) {
            this.onException(tw);
        }
    }

    @Override
    public Class<?>[] supportsEventTypes() {
        return EVENT_TYPES;
    }

    protected boolean supports(ApplicationEvent applicationEvent) {
        return applicationEvent instanceof ApplicationStartingEvent;
    }
}
