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
package com.photowey.popcorn.scheduler.kernel.annotation;

import com.photowey.popcorn.scheduler.service.database.annotation.EnabledScheduleDatabaseService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * {@code EnableKernel}
 *
 * @author photowey
 * @date 2023/07/10
 * @since 1.0.0
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(value = {
        EnableKernel.EnableKernelConfigure.class,
        EnableKernel.EnableKernelDatabaseSelectorConfigure.class,
        EnableKernel.EnableKernelMongoSelectorConfigure.class,
})
public @interface EnableKernel {

    @Configuration
    @ComponentScan(value = {
            "com.photowey.popcorn.scheduler.kernel",
    })
    class EnableKernelConfigure {

    }

    @Configuration
    @ConditionalOnProperty(name = "spring.schedule.popcorn.server.scheduler.kernel.database.enabled", havingValue = "true", matchIfMissing = true)
    @Import(value = {
            EnableKernelDatabaseConfigure.class,
    })
    class EnableKernelDatabaseSelectorConfigure {

    }

    @Configuration
    @ConditionalOnProperty(name = "spring.schedule.popcorn.server.scheduler.kernel.mongo.enabled", havingValue = "true", matchIfMissing = false)
    @Import(value = {
            EnableKernelMongoConfigure.class,
    })
    class EnableKernelMongoSelectorConfigure {

    }

    @Configuration
    @EnabledScheduleDatabaseService
    class EnableKernelDatabaseConfigure {

    }

    @Configuration
    class EnableKernelMongoConfigure {

    }
}
