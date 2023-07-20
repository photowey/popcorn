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

import com.photowey.popcorn.autoconfigure.engine.property.PropertyEngine;
import com.photowey.popcorn.scheduler.core.domain.entity.AbstractEntity;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.JdkIdGenerator;

import java.time.LocalDateTime;

/**
 * {@code TestBase}
 *
 * @author photowey
 * @date 2023/07/19
 * @since 1.0.0
 */
public abstract class TestBase {

    @Autowired
    protected ScheduleAppDatabaseService scheduleAppDatabaseService;
    @Autowired
    protected ScheduleGroupDatabaseService scheduleGroupDatabaseService;
    @Autowired
    protected ScheduleInstanceDatabaseService scheduleInstanceDatabaseService;

    @Autowired
    protected PropertyEngine propertyEngine;

    protected JdkIdGenerator generator;

    @BeforeEach
    public void init() {
        this.generator = new JdkIdGenerator();
    }

    protected <T> void populateInitFields(AbstractEntity<T> tt) {
        LocalDateTime now = LocalDateTime.now();
        tt.setCreateTime(now);
        tt.setUpdateTime(now);
        tt.setDeleted(0);
    }
}
