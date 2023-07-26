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
import com.photowey.popcorn.scheduler.core.domain.entity.ScheduleTask;
import com.photowey.popcorn.server.App;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * {@code ScheduleTaskDatabaseServiceTest}
 *
 * @author photowey
 * @date 2023/07/26
 * @since 1.0.0
 */
@SpringBootTest(classes = {App.class})
class ScheduleTaskDatabaseServiceTest extends TestBase {

    @Test
    void testSave() {
        Long appId = 1681701037965729793L;
        Long groupId = 1681331499386470402L;
        Long jobId = 1683861477051330562L;

        ScheduleTask scheduleTask = ScheduleTask.builder()
                .appId(appId)
                .groupId(groupId)
                .groupCode("ecomm.order.payment.status.delay.query")
                .jobId(jobId)
                .instanceIp("192.168.1.101")
                .instancePort(9320)
                .taskStatus(1)
                .finishedTime(null)
                .failReason(null)
                .retryCount(0)
                .build();

        this.populateInitFields(scheduleTask);

        this.scheduleTaskDatabaseService.save(scheduleTask);
    }

    @Test
    void testInsert() {
        Long appId = 1681701037965729793L;
        Long groupId = 1681331499386470402L;
        Long jobId = 1683861477051330562L;

        ScheduleTask scheduleTask = ScheduleTask.builder()
                .appId(appId)
                .groupId(groupId)
                .groupCode("ecomm.order.payment.status.delay.query")
                .jobId(jobId)
                .instanceIp("192.168.1.102")
                .instancePort(9321)
                .taskStatus(2)
                .finishedTime(SystemClock.LocalDateTime.now())
                .failReason(null)
                .retryCount(0)
                .build();

        this.populateInitFields(scheduleTask);

        this.scheduleTaskDatabaseService.insert(scheduleTask);
    }

    @Test
    void testInsert_failed() {
        Long appId = 1681701037965729793L;
        Long groupId = 1681331499386470402L;
        Long jobId = 1683861477051330562L;

        ScheduleTask scheduleTask = ScheduleTask.builder()
                .appId(appId)
                .groupId(groupId)
                .groupCode("ecomm.order.payment.status.delay.query")
                .jobId(jobId)
                .instanceIp("192.168.1.103")
                .instancePort(9322)
                .taskStatus(3)
                .finishedTime(SystemClock.LocalDateTime.now())
                .failReason("Failed reason")
                .retryCount(0)
                .build();

        this.populateInitFields(scheduleTask);

        this.scheduleTaskDatabaseService.insert(scheduleTask);
    }
}
