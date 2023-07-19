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
package com.photowey.popcorn.scheduler.service.database;

import com.photowey.popcorn.scheduler.core.domain.entity.ScheduleApp;
import com.photowey.popcorn.server.App;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * {@code ScheduleAppDatabaseServiceTest}
 *
 * @author photowey
 * @date 2023/07/18
 * @since 1.0.0
 */
@SpringBootTest(classes = {App.class})
class ScheduleAppDatabaseServiceTest extends TestBase {

    //@Test
    void testSave() {
        String clientId = this.uuid();
        ScheduleApp app = ScheduleApp.builder()
                .appCode("popcorn.order")
                .appName("Popcorn Order Service")
                .clientId(clientId)
                .clientSecret(DigestUtils.md5DigestAsHex(clientId.getBytes(StandardCharsets.UTF_8)))
                .build();

        this.populateInitFields(app);

        this.scheduleAppDatabaseService.save(app);
    }

    //@Test
    void testInsert() {
        String clientId = this.uuid();
        ScheduleApp app = ScheduleApp.builder()
                .appCode("popcorn.user")
                .appName("Popcorn User Service")
                .clientId(clientId)
                .clientSecret(DigestUtils.md5DigestAsHex(clientId.getBytes(StandardCharsets.UTF_8)))
                .build();

        this.populateInitFields(app);

        this.scheduleAppDatabaseService.insert(app);
    }

    private String uuid() {
        return this.generator.generateId().toString().replaceAll("-", "");
    }
}