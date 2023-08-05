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
package com.photowey.popcorn.scheduler.service.engine;

import com.photowey.popcorn.app.core.engine.AbstractEngine;
import com.photowey.popcorn.autoconfigure.engine.root.PopcornEngine;
import com.photowey.popcorn.autoconfigure.engine.root.PopcornEngineAware;
import com.photowey.popcorn.scheduler.service.*;

/**
 * {@code ServiceEngineImpl}
 *
 * @author photowey
 * @date 2023/07/30
 * @since 1.0.0
 */
public class ServiceEngineImpl extends AbstractEngine implements ServiceEngine, PopcornEngineAware {

    private PopcornEngine popcornEngine;

    // ----------------------------------------------------------------

    @Override
    public void setPopcornEngine(PopcornEngine popcornEngine) {
        this.popcornEngine = popcornEngine;
    }

    // ----------------------------------------------------------------

    @Override
    public PopcornEngine popcornEngine() {
        return this.popcornEngine;
    }

    // ----------------------------------------------------------------

    @Override
    public ScheduleAppService scheduleAppService() {
        return this.beanFactory().getBean(ScheduleAppService.class);
    }

    @Override
    public ScheduleGroupService scheduleGroupService() {
        return this.beanFactory().getBean(ScheduleGroupService.class);
    }

    @Override
    public ScheduleInstanceService scheduleInstanceService() {
        return this.beanFactory().getBean(ScheduleInstanceService.class);
    }

    @Override
    public ScheduleJobService scheduleJobService() {
        return this.beanFactory().getBean(ScheduleJobService.class);
    }

    @Override
    public ScheduleTaskService scheduleTaskService() {
        return this.beanFactory().getBean(ScheduleTaskService.class);
    }

}
