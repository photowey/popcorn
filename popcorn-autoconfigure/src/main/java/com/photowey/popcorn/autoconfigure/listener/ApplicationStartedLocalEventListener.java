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
package com.photowey.popcorn.autoconfigure.listener;

import com.photowey.popcorn.app.core.getter.EnvironmentGetter;
import com.photowey.popcorn.starting.event.ApplicationStartedLocalEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * {@code ApplicationStartedLocalEventListener}
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
public class ApplicationStartedLocalEventListener implements ApplicationListener<ApplicationStartedLocalEvent>, EnvironmentAware, EnvironmentGetter {

    private static final Logger log = LoggerFactory.getLogger(ApplicationStartedLocalEventListener.class);

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Environment environment() {
        return this.environment;
    }

    @Override
    public void onApplicationEvent(ApplicationStartedLocalEvent event) {
        this.sync();
    }

    private void sync() {
        log.info("Popcorn: started on port(s): {} (http) with context path '{}'", this.determineServerPort(), this.determineServerServletContextPath());
    }

    private void async() {

    }
}
