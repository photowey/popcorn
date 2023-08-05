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
package com.photowey.popcorn.scheduler.service.database.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.photowey.popcorn.scheduler.core.domain.dto.AppRegisterDTO;
import com.photowey.popcorn.scheduler.core.domain.entity.ScheduleApp;
import com.photowey.popcorn.scheduler.core.domain.payload.AppRegisterPayload;
import com.photowey.popcorn.scheduler.repository.database.impl.ScheduleAppDatabaseRepository;
import com.photowey.popcorn.scheduler.service.database.ScheduleAppDatabaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@code ScheduleAppDatabaseServiceImpl}
 *
 * @author photowey
 * @date 2023/07/16
 * @since 1.0.0
 */
@Service
public class ScheduleAppDatabaseServiceImpl extends ServiceImpl<ScheduleAppDatabaseRepository, ScheduleApp> implements ScheduleAppDatabaseService {

    // ----------------------------------------------------------------

    /**
     * Register schedule app info.
     *
     * @param payload {@link AppRegisterPayload}
     * @return @{@link AppRegisterDTO}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AppRegisterDTO register(AppRegisterPayload payload) {
        throw new UnsupportedOperationException("UnSupported now.");
    }
}
