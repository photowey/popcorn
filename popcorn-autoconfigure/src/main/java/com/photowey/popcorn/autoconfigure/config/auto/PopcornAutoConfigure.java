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
package com.photowey.popcorn.autoconfigure.config.auto;

import com.photowey.popcorn.app.core.notify.DefaultNotifyCenter;
import com.photowey.popcorn.app.core.notify.NotifyCenter;
import com.photowey.popcorn.autoconfigure.injector.ApplicationContextInjector;
import com.photowey.popcorn.autoconfigure.listener.ApplicationStartedLocalEventListener;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * {@code PopcornAutoConfigure}
 *
 * @author photowey
 * @date 2023/07/08
 * @since 1.0.0
 */
@AutoConfiguration
@Import(value = {
        PopcornAutoConfigure.InjectorConfigure.class,
        PopcornAutoConfigure.NotifyCenterConfigure.class,
        PopcornAutoConfigure.EventListenerConfigure.class,
})
public class PopcornAutoConfigure {

    @Configuration
    static class InjectorConfigure {

        @Bean
        public ApplicationContextInjector applicationContextInjector() {
            return new ApplicationContextInjector();
        }
    }

    @Configuration
    static class NotifyCenterConfigure {

        @Bean
        @ConditionalOnMissingBean(NotifyCenter.class)
        public NotifyCenter notifyCenter() {
            return new DefaultNotifyCenter();
        }
    }

    @Configuration
    static class EventListenerConfigure {

        @Bean
        public ApplicationStartedLocalEventListener applicationStartedLocalEventListener() {
            return new ApplicationStartedLocalEventListener();
        }
    }
}
