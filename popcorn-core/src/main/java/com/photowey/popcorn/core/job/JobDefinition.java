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
package com.photowey.popcorn.core.job;

/**
 * {@code JobDefinition}
 *
 * @author photowey
 * @date 2023/07/10
 * @since 1.0.0
 */
public interface JobDefinition {

    /**
     * The name of job.
     * <p>
     *
     * Example:
     * <p>
     * - `${xxx.module.order.status.delayed.query}`
     * <p>
     * - `${xxx.module.product.index.list.schedule.refresh}`
     *
     * @return the job name.
     */
    String getName();

    /**
     * The name of job group.
     * <p>
     *
     * Example:
     * <p>
     * - `${spring.application.name}`
     *
     * @return the group name.
     */
    String getGroup();

}
