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

import com.baomidou.mybatisplus.extension.service.IService;
import com.photowey.popcorn.scheduler.core.domain.entity.ScheduleTask;
import com.photowey.popcorn.scheduler.service.ScheduleTaskService;

import java.util.List;

/**
 * {@code ScheduleTaskDatabaseService}
 *
 * @author photowey
 * @date 2023/07/16
 * @since 1.0.0
 */
public interface ScheduleTaskDatabaseService extends ScheduleTaskService, IService<ScheduleTask> {

    @Override
    default boolean insert(ScheduleTask tt) {
        return this.save(tt);
    }

    @Override
    default boolean batchInsert(List<ScheduleTask> tts) {
        return this.saveBatch(tts);
    }

    @Override
    default boolean updatee(ScheduleTask tt) {
        return this.updateById(tt);
    }

    @Override
    default boolean batchUpdatee(List<ScheduleTask> tts) {
        return this.updateBatchById(tts);
    }

    @Override
    default boolean delete(ScheduleTask tt) {
        return this.removeById(tt);
    }

    @Override
    default boolean deleteById(Long id) {
        return this.removeById(id);
    }

}
