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
import com.photowey.popcorn.scheduler.core.domain.entity.ScheduleApp;
import com.photowey.popcorn.scheduler.repository.database.impl.ScheduleAppDatabaseRepository;
import com.photowey.popcorn.scheduler.service.database.ScheduleAppDatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@code ScheduleAppDatabaseServiceImpl}
 *
 * @author photowey
 * @date 2023/07/16
 * @since 1.0.0
 */
@Service
public class ScheduleAppDatabaseServiceImpl extends ServiceImpl<ScheduleAppDatabaseRepository, ScheduleApp> implements ScheduleAppDatabaseService {

    @Override
    public boolean insert(ScheduleApp tt) {
        return this.save(tt);
    }

    @Override
    public boolean batchInsert(List<ScheduleApp> tts) {
        return this.saveBatch(tts);
    }

    @Override
    public boolean updatee(ScheduleApp tt) {
        return this.updateById(tt);
    }

    @Override
    public boolean batchUpdatee(List<ScheduleApp> tts) {
        return this.updateBatchById(tts);
    }

    @Override
    public boolean delete(ScheduleApp tt) {
        return this.removeById(tt);
    }

    @Override
    public boolean deleteById(Long id) {
        return this.removeById(id);
    }
}
