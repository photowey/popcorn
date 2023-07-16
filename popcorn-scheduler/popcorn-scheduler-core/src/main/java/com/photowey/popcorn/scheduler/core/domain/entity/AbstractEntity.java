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
package com.photowey.popcorn.scheduler.core.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * {@code AbstractEntity}
 *
 * @author photowey
 * @date 2023/07/12
 * @since 1.0.0
 */
public abstract class AbstractEntity<T> implements Serializable {

    protected Long id;
    protected LocalDateTime createTime;
    protected LocalDateTime updateTime;
    protected Integer delete;

    public AbstractEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public Integer getDelete() {
        return this.delete;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setCreateTime(final LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(final LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public void setDelete(final Integer delete) {
        this.delete = delete;
    }
}
