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
import java.util.concurrent.TimeUnit;

/**
 * {@code ScheduleGroup}
 *
 * @author photowey
 * @date 2023/07/12
 * @since 1.0.0
 */
public class ScheduleGroup extends AbstractEntity<ScheduleGroup> implements Serializable {

    private static final long serialVersionUID = -1230528783360759449L;

    /**
     * The ID of {@link ScheduleApp}
     */
    private Long appId;
    /**
     * The code of this group job.
     * <p>
     *
     * Example:
     * <p>
     * - ecomm.order.payment.status.delay.query
     */
    private String groupCode;
    /**
     * The name of this group job.
     * <p>
     * - Delay query task for order payment status
     */
    private String groupName;
    /**
     * The type of this job.
     * <p>
     * - 1.FixedRate
     * <p>
     * - 2.FixedDelay
     * <p>
     * - 3.Cron
     */
    private Integer jobType;
    private String cron;
    /**
     * The context of this job.
     */
    private String context;
    /**
     * The RPC protocol of this job, default HTTP.
     */
    private String protocol;
    private Long initialDelay;
    private Long delay;
    private TimeUnit timeUnit;
    /**
     * The next trigger time of this group job.
     */
    private LocalDateTime triggerTime;

    public static ScheduleGroupBuilder builder() {
        return new ScheduleGroupBuilder();
    }

    public Long getAppId() {
        return this.appId;
    }

    public String getGroupCode() {
        return this.groupCode;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public Integer getJobType() {
        return this.jobType;
    }

    public String getCron() {
        return this.cron;
    }

    public String getContext() {
        return this.context;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public Long getInitialDelay() {
        return this.initialDelay;
    }

    public Long getDelay() {
        return this.delay;
    }

    public TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    public LocalDateTime getTriggerTime() {
        return this.triggerTime;
    }

    public void setAppId(final Long appId) {
        this.appId = appId;
    }

    public void setGroupCode(final String groupCode) {
        this.groupCode = groupCode;
    }

    public void setGroupName(final String groupName) {
        this.groupName = groupName;
    }

    public void setJobType(final Integer jobType) {
        this.jobType = jobType;
    }

    public void setCron(final String cron) {
        this.cron = cron;
    }

    public void setContext(final String context) {
        this.context = context;
    }

    public void setProtocol(final String protocol) {
        this.protocol = protocol;
    }

    public void setInitialDelay(final Long initialDelay) {
        this.initialDelay = initialDelay;
    }

    public void setDelay(final Long delay) {
        this.delay = delay;
    }

    public void setTimeUnit(final TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void setTriggerTime(final LocalDateTime triggerTime) {
        this.triggerTime = triggerTime;
    }

    public ScheduleGroup() {
    }

    public ScheduleGroup(final Long appId, final String groupCode, final String groupName, final Integer jobType, final String cron, final String context, final String protocol, final Long initialDelay, final Long delay, final TimeUnit timeUnit, final LocalDateTime triggerTime) {
        this.appId = appId;
        this.groupCode = groupCode;
        this.groupName = groupName;
        this.jobType = jobType;
        this.cron = cron;
        this.context = context;
        this.protocol = protocol;
        this.initialDelay = initialDelay;
        this.delay = delay;
        this.timeUnit = timeUnit;
        this.triggerTime = triggerTime;
    }

    public static class ScheduleGroupBuilder {
        private Long appId;
        private String groupCode;
        private String groupName;
        private Integer jobType;
        private String cron;
        private String context;
        private String protocol;
        private Long initialDelay;
        private Long delay;
        private TimeUnit timeUnit;
        private LocalDateTime triggerTime;

        ScheduleGroupBuilder() {
        }

        public ScheduleGroupBuilder appId(final Long appId) {
            this.appId = appId;
            return this;
        }

        public ScheduleGroupBuilder groupCode(final String groupCode) {
            this.groupCode = groupCode;
            return this;
        }

        public ScheduleGroupBuilder groupName(final String groupName) {
            this.groupName = groupName;
            return this;
        }

        public ScheduleGroupBuilder jobType(final Integer jobType) {
            this.jobType = jobType;
            return this;
        }

        public ScheduleGroupBuilder cron(final String cron) {
            this.cron = cron;
            return this;
        }

        public ScheduleGroupBuilder context(final String context) {
            this.context = context;
            return this;
        }

        public ScheduleGroupBuilder protocol(final String protocol) {
            this.protocol = protocol;
            return this;
        }

        public ScheduleGroupBuilder initialDelay(final Long initialDelay) {
            this.initialDelay = initialDelay;
            return this;
        }

        public ScheduleGroupBuilder delay(final Long delay) {
            this.delay = delay;
            return this;
        }

        public ScheduleGroupBuilder timeUnit(final TimeUnit timeUnit) {
            this.timeUnit = timeUnit;
            return this;
        }

        public ScheduleGroupBuilder triggerTime(final LocalDateTime triggerTime) {
            this.triggerTime = triggerTime;
            return this;
        }

        public ScheduleGroup build() {
            return new ScheduleGroup(this.appId, this.groupCode, this.groupName, this.jobType, this.cron, this.context, this.protocol, this.initialDelay, this.delay, this.timeUnit, this.triggerTime);
        }

        public String toString() {
            return "ScheduleGroup.ScheduleGroupBuilder(appId=" + this.appId + ", groupCode=" + this.groupCode + ", groupName=" + this.groupName + ", jobType=" + this.jobType + ", cron=" + this.cron + ", context=" + this.context + ", protocol=" + this.protocol + ", initialDelay=" + this.initialDelay + ", delay=" + this.delay + ", timeUnit=" + this.timeUnit + ", triggerTime=" + this.triggerTime + ")";
        }
    }
}
