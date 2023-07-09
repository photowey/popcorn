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
package com.photowey.popcorn.autoconfigure.config;

import com.photowey.popcorn.autoconfigure.engine.executor.ExecutorEngine;
import com.photowey.popcorn.autoconfigure.engine.executor.ExecutorEngineImpl;
import com.photowey.popcorn.autoconfigure.engine.root.PopcornEngine;
import com.photowey.popcorn.autoconfigure.engine.root.PopcornEngineImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@code EngineConfigure}
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
@Configuration
public class EngineConfigure {

    @Bean
    public PopcornEngine popcornEngine() {
        return new PopcornEngineImpl();
    }

    @Bean
    @ConditionalOnMissingBean(ExecutorEngine.class)
    public ExecutorEngine executorEngine() {
        return new ExecutorEngineImpl();
    }

}
