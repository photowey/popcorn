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
package com.photowey.popcorn.scheduler.service;

import java.util.List;

/**
 * {@code ScheduleCrudService}
 *
 * @author photowey
 * @date 2023/07/16
 * @since 1.0.0
 */
public interface ScheduleCrudService<T, ID> {

    default boolean insert(T t) {
        return true;
    }

    default boolean batchInsert(List<T> ts) {
        return true;
    }

    default boolean updatee(T t) {
        return true;
    }

    default boolean batchUpdatee(List<T> ts) {
        return true;
    }

    default boolean delete(T t) {
        return true;
    }

    default boolean deleteById(ID id) {
        return true;
    }

}