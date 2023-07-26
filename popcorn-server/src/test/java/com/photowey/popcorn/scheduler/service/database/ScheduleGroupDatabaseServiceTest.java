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
import com.photowey.popcorn.scheduler.core.domain.entity.ScheduleGroup;
import com.photowey.popcorn.server.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * {@code ScheduleGroupDatabaseServiceTest}
 *
 * @author photowey
 * @date 2023/07/19
 * @since 1.0.0
 */
@SpringBootTest(classes = {App.class})
class ScheduleGroupDatabaseServiceTest extends TestBase {

    @Autowired
    private ScheduleGroupDatabaseService scheduleGroupDatabaseService;

    //@Test
    void testSave() {
        Long appId = 1681331499386470402L;
        ScheduleGroup group = ScheduleGroup.builder()
                .appId(appId)
                .groupCode("ecomm.order.payment.status.delay.query")
                .groupName("Delay query task for order payment status")
                .jobType(3)
                .cron("0/15 * * * * ?")
                .context("url://3/github/https://github.com/photowey")
                .rpcProtocol("HTTP")
                .initialDelay(0L)
                .delay(0L)
                .period(0L)
                .timeUnit(TimeUnit.SECONDS)
                .triggerTime(SystemClock.LocalDateTime.now())
                .build();

        this.populateInitFields(group);

        this.scheduleGroupDatabaseService.save(group);
    }

    //@Test
    void testInsert() {
        Long appId = 1681331499386470402L;
        ScheduleGroup group = ScheduleGroup.builder()
                .appId(appId)
                .groupCode("ecomm.order.payment.status.delay.query")
                .groupName("Delay query task for order payment status")
                .jobType(1)
                .cron(null)
                .context("url://1/github/https://github.com/photowey")
                .rpcProtocol("HTTP")
                .initialDelay(5L)
                .delay(0L)
                .period(15L)
                .timeUnit(TimeUnit.SECONDS)
                .triggerTime(SystemClock.LocalDateTime.now())
                .build();

        this.populateInitFields(group);

        this.scheduleGroupDatabaseService.insert(group);
    }

    //@Test
    void testInsert_v2() {
        Long appId = 1681331499386470402L;
        ScheduleGroup group = ScheduleGroup.builder()
                .appId(appId)
                .groupCode("ecomm.order.payment.status.delay.query")
                .groupName("Delay query task for order payment status")
                .jobType(2)
                .cron(null)
                .context("url://2/github/https://github.com/photowey")
                .rpcProtocol("HTTP")
                .initialDelay(5L)
                .delay(15L)
                .period(0L)
                .timeUnit(TimeUnit.SECONDS)
                .triggerTime(SystemClock.LocalDateTime.now())
                .build();

        this.populateInitFields(group);

        this.scheduleGroupDatabaseService.insert(group);
    }

}
