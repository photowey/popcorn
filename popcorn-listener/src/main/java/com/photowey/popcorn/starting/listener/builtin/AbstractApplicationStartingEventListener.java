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

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * {@code AbstractApplicationStartingEventListener}
 *
 * @author photowey
 * @date 2023/07/08
 * @since 1.0.0
 */
public abstract class AbstractApplicationStartingEventListener extends AbstractCommonApplicationEventListener {

    protected static final Class<?>[] EVENT_TYPES = {
            ApplicationStartingEvent.class,
    };

    protected final AtomicBoolean started = new AtomicBoolean(false);

    /**
     * Handle the event {@link ApplicationStartingEvent}
     *
     * @param event {@link ApplicationStartingEvent}
     */
    public abstract void onEvent(ApplicationStartingEvent event);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        try {
            if (this.started.compareAndSet(false, true)
                    && this.supports(applicationEvent)) {
                this.onEvent((ApplicationStartingEvent) applicationEvent);
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
