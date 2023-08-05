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
package com.photowey.popcorn.scheduler.service.database.annotation;

import com.photowey.popcorn.scheduler.service.engine.ServiceEngine;
import com.photowey.popcorn.scheduler.service.engine.ServiceEngineAwareBeanPostProcessor;
import com.photowey.popcorn.scheduler.service.engine.ServiceEngineImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * {@code EnabledScheduleDatabaseService}
 *
 * @author photowey
 * @date 2023/07/16
 * @since 1.0.0
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(value = {
        ServiceEngineAwareBeanPostProcessor.class,
        EnabledScheduleDatabaseService.EnabledScheduleDatabaseServiceConfigure.class,
})
public @interface EnabledScheduleDatabaseService {

    @Configuration
    @ComponentScan(value = {
            "com.photowey.popcorn.scheduler.service.database",
    })
    @MapperScan(value = {
            "com.photowey.popcorn.scheduler.repository.database.impl"
    })
    class EnabledScheduleDatabaseServiceConfigure {

        /**
         * Config {@link ServiceEngine}
         *
         * @return {@link ServiceEngine}
         */
        @Bean
        public ServiceEngine serviceEngine() {
            return new ServiceEngineImpl();
        }
    }

}
