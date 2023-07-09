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
package com.photowey.popcorn.server.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.photowey.popcorn.app.core.api.health.HealthzApi;
import com.photowey.popcorn.autoconfigure.engine.root.PopcornEngine;
import com.photowey.popcorn.autoconfigure.engine.root.PopcornEngineAware;
import com.photowey.popcorn.core.health.status.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestOperations;

import java.util.concurrent.CompletableFuture;

/**
 * {@code ApplicationStartedListener}
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
@Configuration
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent>, PopcornEngineAware, HealthzApi {

    private static final Logger log = LoggerFactory.getLogger(ApplicationStartedListener.class);

    private final RestOperations restOperations;
    private final ObjectMapper objectMapper;

    private PopcornEngine popcornEngine;

    public ApplicationStartedListener(RestOperations restOperations, ObjectMapper objectMapper) {
        this.restOperations = restOperations;
        this.objectMapper = objectMapper;
    }

    @Override
    public void setPopcornEngine(PopcornEngine popcornEngine) {
        this.popcornEngine = popcornEngine;
    }

    @Override
    public Environment environment() {
        return this.popcornEngine.environment();
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        CompletableFuture.runAsync(this::async, this.popcornEngine.executorEngine().eventAsyncExecutor());
    }

    private void async() {
        this.doConnectDatabase();
        this.doHeartbeat();
    }

    private void doConnectDatabase() {

    }

    private void doHeartbeat() {
        try {
            String api = this.populateHealthzApi();
            Status status = this.restOperations.getForObject(api, Status.class);
            String body = this.objectMapper.writeValueAsString(status);
            log.info("Popcorn: fire.app.start.health.check, the popcorn.server.health.api.response.body: {}", body);
        } catch (Exception e) {
            log.error("Popcorn: fire.app.start.health.check failed", e);
        }
    }
}
