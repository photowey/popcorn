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

import com.photowey.popcorn.app.core.task.MdcTaskDecorator;
import com.photowey.popcorn.common.util.HardwareUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * {@code ExecutorConfigure}
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
public class ExecutorConfigure {

    /**
     * Common {@link ThreadPoolTaskExecutor}.
     *
     * @return {@link ThreadPoolTaskExecutor}
     */
    @Bean("commonAsyncExecutor")
    public ThreadPoolTaskExecutor commonAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(Math.max(1 << 3, HardwareUtils.getNcpu() + 1));
        taskExecutor.setMaxPoolSize(Math.max(1 << 3, HardwareUtils.getDoubleNcpu()));
        taskExecutor.setQueueCapacity(1 << 10);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadGroupName("async");
        taskExecutor.setThreadNamePrefix("cmn" + "-");

        this.populateDefaultConfig(taskExecutor);

        return taskExecutor;
    }

    /**
     * Event {@link ThreadPoolTaskExecutor}.
     *
     * @return {@link ThreadPoolTaskExecutor}
     */
    @Bean("eventAsyncExecutor")
    public ThreadPoolTaskExecutor eventAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(1 << 2);
        taskExecutor.setMaxPoolSize(1 << 3);
        taskExecutor.setQueueCapacity(1 << 10);
        taskExecutor.setKeepAliveSeconds(30);
        taskExecutor.setThreadGroupName("async");
        taskExecutor.setThreadNamePrefix("evt" + "-");

        this.populateDefaultConfig(taskExecutor);

        return taskExecutor;
    }

    private void populateDefaultConfig(ThreadPoolTaskExecutor taskExecutor) {
        taskExecutor.setTaskDecorator(this.createMdcTaskDecorator());
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.setAllowCoreThreadTimeOut(true);
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.initialize();
    }

    private TaskDecorator createMdcTaskDecorator() {
        return new MdcTaskDecorator();
    }
}
