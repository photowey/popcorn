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
package com.photowey.popcorn.scheduler.core.domain.enrity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * {@code ScheduleJob}
 *
 * @author photowey
 * @date 2023/07/13
 * @since 1.0.0
 */
public class ScheduleJob extends AbstractEntity<ScheduleJob> implements Serializable {

    private static final long serialVersionUID = 1114255661305604384L;

/*
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
*/

    /**
     * The ID of {@link ScheduleApp}
     */
    private Long appId;
    /**
     * The ID of {@link ScheduleGroup}
     */
    private Long groupId;
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
     * The status of current schedule.
     * <p>
     * - 1: scheduling(pending)
     * - 2: succeed
     * - 3: failed
     */
    private Integer triggerStatus;
    private LocalDateTime triggerTime;

    public static ScheduleJobBuilder builder() {
        return new ScheduleJobBuilder();
    }

    public Long getAppId() {
        return this.appId;
    }

    public Long getGroupId() {
        return this.groupId;
    }

    public String getGroupCode() {
        return this.groupCode;
    }

    public Integer getTriggerStatus() {
        return this.triggerStatus;
    }

    public LocalDateTime getTriggerTime() {
        return this.triggerTime;
    }

    public void setAppId(final Long appId) {
        this.appId = appId;
    }

    public void setGroupId(final Long groupId) {
        this.groupId = groupId;
    }

    public void setGroupCode(final String groupCode) {
        this.groupCode = groupCode;
    }

    public void setTriggerStatus(final Integer triggerStatus) {
        this.triggerStatus = triggerStatus;
    }

    public void setTriggerTime(final LocalDateTime triggerTime) {
        this.triggerTime = triggerTime;
    }

    public ScheduleJob() {
    }

    public ScheduleJob(final Long appId, final Long groupId, final String groupCode, final Integer triggerStatus, final LocalDateTime triggerTime) {
        this.appId = appId;
        this.groupId = groupId;
        this.groupCode = groupCode;
        this.triggerStatus = triggerStatus;
        this.triggerTime = triggerTime;
    }

    public static class ScheduleJobBuilder {
        private Long appId;
        private Long groupId;
        private String groupCode;
        private Integer triggerStatus;
        private LocalDateTime triggerTime;

        ScheduleJobBuilder() {
        }

        public ScheduleJobBuilder appId(final Long appId) {
            this.appId = appId;
            return this;
        }

        public ScheduleJobBuilder groupId(final Long groupId) {
            this.groupId = groupId;
            return this;
        }

        public ScheduleJobBuilder groupCode(final String groupCode) {
            this.groupCode = groupCode;
            return this;
        }

        public ScheduleJobBuilder triggerStatus(final Integer triggerStatus) {
            this.triggerStatus = triggerStatus;
            return this;
        }

        public ScheduleJobBuilder triggerTime(final LocalDateTime triggerTime) {
            this.triggerTime = triggerTime;
            return this;
        }

        public ScheduleJob build() {
            return new ScheduleJob(this.appId, this.groupId, this.groupCode, this.triggerStatus, this.triggerTime);
        }

        public String toString() {
            return "ScheduleJob.ScheduleJobBuilder(appId=" + this.appId + ", groupId=" + this.groupId + ", groupCode=" + this.groupCode + ", triggerStatus=" + this.triggerStatus + ", triggerTime=" + this.triggerTime + ")";
        }
    }
}
