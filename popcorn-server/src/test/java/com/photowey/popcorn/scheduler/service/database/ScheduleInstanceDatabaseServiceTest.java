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

import com.photowey.popcorn.common.clock.SystemClock;
import com.photowey.popcorn.scheduler.core.domain.entity.ScheduleInstance;
import com.photowey.popcorn.server.App;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * {@code ScheduleInstanceDatabaseServiceTest}
 *
 * @author photowey
 * @date 2023/07/20
 * @since 1.0.0
 */
@SpringBootTest(classes = {App.class})
class ScheduleInstanceDatabaseServiceTest extends TestBase {

    //@Test
    void testSave() {
        Long appId = 1681701037965729793L;
        Long groupId = 1681331499386470402L;
        ScheduleInstance instance = ScheduleInstance.builder()
                .appId(appId)
                .groupId(groupId)
                .instanceIp("192.168.1.101")
                .instancePort(9320)
                .rpcProtocol("HTTP")
                .heartbeatTime(SystemClock.LocalDateTime.now())
                .build();

        this.populateInitFields(instance);

        this.scheduleInstanceDatabaseService.save(instance);
    }

    //@Test
    void testInsert() {
        Long appId = 1681701037965729793L;
        Long groupId = 1681331499386470402L;
        ScheduleInstance instance = ScheduleInstance.builder()
                .appId(appId)
                .groupId(groupId)
                .instanceIp("192.168.1.102")
                .instancePort(9320)
                .rpcProtocol("HTTP")
                .heartbeatTime(SystemClock.LocalDateTime.now())
                .build();

        this.populateInitFields(instance);

        this.scheduleInstanceDatabaseService.insert(instance);
    }
}
