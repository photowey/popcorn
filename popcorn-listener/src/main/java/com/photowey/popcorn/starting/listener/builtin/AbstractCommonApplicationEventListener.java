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

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;

/**
 * {@code AbstractCommonApplicationEventListener}
 *
 * @author photowey
 * @date 2023/07/08
 * @since 1.0.0
 */
public abstract class AbstractCommonApplicationEventListener implements
        GenericApplicationListener, Ordered, ApplicationContextAware, EnvironmentAware {

    protected static final Class<?>[] SOURCE_TYPES = {SpringApplication.class, ApplicationContext.class};

    protected ConfigurableApplicationContext applicationContext;

    protected Environment environment;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * Support event types.
     *
     * @return the event types
     */
    public abstract Class<?>[] supportsEventTypes();

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return this.isAssignableFrom(sourceType, SOURCE_TYPES);
    }

    @Override
    public boolean supportsEventType(ResolvableType resolvableType) {
        return this.isAssignableFrom(resolvableType.getRawClass(), this.supportsEventTypes());
    }

    /**
     * On throwable.
     *
     * @param tw {@link Throwable}
     */
    protected void onException(Throwable tw) {

    }

    protected boolean isAssignableFrom(Class<?> type, Class<?>... supportedTypes) {
        if (type != null) {
            for (Class<?> supportedType : supportedTypes) {
                if (supportedType.isAssignableFrom(type)) {
                    return true;
                }
            }
        }

        return false;
    }
}
