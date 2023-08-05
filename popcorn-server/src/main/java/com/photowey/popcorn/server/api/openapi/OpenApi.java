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
package com.photowey.popcorn.server.api.openapi;

import com.photowey.popcorn.scheduler.core.domain.dto.AppRegisterDTO;
import com.photowey.popcorn.scheduler.core.domain.payload.AppRegisterPayload;
import com.photowey.popcorn.scheduler.service.engine.ServiceEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@code OpenApi}
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/openapi")
public class OpenApi {

    private static final Logger log = LoggerFactory.getLogger(OpenApi.class);

    private final ServiceEngine serviceEngine;

    public OpenApi(ServiceEngine serviceEngine) {
        this.serviceEngine = serviceEngine;
    }

    /**
     * POST :/register
     * Register schedule app info.
     *
     * @param payload {@link AppRegisterPayload}
     * @return {@link AppRegisterDTO}
     * @see * http://localhost:9320/popcorn/v1/openapi/register
     */
    @PostMapping("/register")
    public ResponseEntity<AppRegisterDTO> register(@RequestBody @Validated AppRegisterPayload payload) {
        AppRegisterDTO registered = this.serviceEngine.scheduleAppService().register(payload);
        return new ResponseEntity<>(registered, HttpStatus.OK);
    }
}
