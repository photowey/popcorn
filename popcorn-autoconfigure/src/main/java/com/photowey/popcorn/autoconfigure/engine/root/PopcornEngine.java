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
package com.photowey.popcorn.autoconfigure.engine.root;

import com.photowey.popcorn.app.core.engine.Engine;
import com.photowey.popcorn.autoconfigure.engine.executor.ExecutorEngine;
import com.photowey.popcorn.autoconfigure.engine.property.PropertyEngine;

/**
 * {@code PopcornEngine}
 * Popcorn root engine.
 * <p>
 * Popcorn 根引擎
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
public interface PopcornEngine extends Engine {

    /**
     * Popcorn thread pool root engine.
     * <p>
     * Popcorn 线程池根引擎
     *
     * @return {@link ExecutorEngine}
     */
    ExecutorEngine executorEngine();

    /**
     * Popcorn property root engine.
     * <p>
     * Popcorn 属性绑定根引擎
     *
     * @return {@link PropertyEngine}
     */
    PropertyEngine propertyEngine();

}
