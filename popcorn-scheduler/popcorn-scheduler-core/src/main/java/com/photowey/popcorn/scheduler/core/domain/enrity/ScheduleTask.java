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
 * {@code ScheduleTask}
 * <p>
 * Single-Model:
 * <p>
 * ScheduleJob
 * <p>
 * - Task1
 *
 * <p>
 * Broadcast-Model:
 * <p>
 * ScheduleJob
 * <p>
 * - Task1
 * <p>
 * - Task2
 * <p>
 * -...
 * <p>
 * - TaskN
 *
 * @author photowey
 * @date 2023/07/13
 * @since 1.0.0
 */
public class ScheduleTask extends AbstractEntity<ScheduleTask> implements Serializable {

    private static final long serialVersionUID = 4969300587327116755L;

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
     * The ID of {@link ScheduleJob}
     */
    private Long jobId;
    /**
     * The IP of schedule instance and shared with client Spring Boot app.
     */
    private String instanceIp;
    /**
     * The port of schedule instance and shared with client Spring Boot app.
     */
    private Integer instancePort;
    /**
     * The status of schedule task of this instance.
     * <p>
     * - 1: scheduling(pending)
     * - 2: succeed
     * - 3: failed
     */
    private Integer taskStatus;
    /**
     * The finished time of schedule task of this instance.
     */
    private LocalDateTime finishedTime;
    /**
     * The fail reason of schedule task of this instance.
     */
    private String failReason;
    /**
     * The count of retry, default 0.
     */
    private Integer retryCount;

    public static ScheduleTaskBuilder builder() {
        return new ScheduleTaskBuilder();
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

    public Long getJobId() {
        return this.jobId;
    }

    public String getInstanceIp() {
        return this.instanceIp;
    }

    public Integer getInstancePort() {
        return this.instancePort;
    }

    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public LocalDateTime getFinishedTime() {
        return this.finishedTime;
    }

    public String getFailReason() {
        return this.failReason;
    }

    public Integer getRetryCount() {
        return this.retryCount;
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

    public void setJobId(final Long jobId) {
        this.jobId = jobId;
    }

    public void setInstanceIp(final String instanceIp) {
        this.instanceIp = instanceIp;
    }

    public void setInstancePort(final Integer instancePort) {
        this.instancePort = instancePort;
    }

    public void setTaskStatus(final Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setFinishedTime(final LocalDateTime finishedTime) {
        this.finishedTime = finishedTime;
    }

    public void setFailReason(final String failReason) {
        this.failReason = failReason;
    }

    public void setRetryCount(final Integer retryCount) {
        this.retryCount = retryCount;
    }

    public ScheduleTask() {
    }

    public ScheduleTask(final Long appId, final Long groupId, final String groupCode, final Long jobId, final String instanceIp, final Integer instancePort, final Integer taskStatus, final LocalDateTime finishedTime, final String failReason, final Integer retryCount) {
        this.appId = appId;
        this.groupId = groupId;
        this.groupCode = groupCode;
        this.jobId = jobId;
        this.instanceIp = instanceIp;
        this.instancePort = instancePort;
        this.taskStatus = taskStatus;
        this.finishedTime = finishedTime;
        this.failReason = failReason;
        this.retryCount = retryCount;
    }

    public static class ScheduleTaskBuilder {
        private Long appId;
        private Long groupId;
        private String groupCode;
        private Long jobId;
        private String instanceIp;
        private Integer instancePort;
        private Integer taskStatus;
        private LocalDateTime finishedTime;
        private String failReason;
        private Integer retryCount;

        ScheduleTaskBuilder() {
        }

        public ScheduleTaskBuilder appId(final Long appId) {
            this.appId = appId;
            return this;
        }

        public ScheduleTaskBuilder groupId(final Long groupId) {
            this.groupId = groupId;
            return this;
        }

        public ScheduleTaskBuilder groupCode(final String groupCode) {
            this.groupCode = groupCode;
            return this;
        }

        public ScheduleTaskBuilder jobId(final Long jobId) {
            this.jobId = jobId;
            return this;
        }

        public ScheduleTaskBuilder instanceIp(final String instanceIp) {
            this.instanceIp = instanceIp;
            return this;
        }

        public ScheduleTaskBuilder instancePort(final Integer instancePort) {
            this.instancePort = instancePort;
            return this;
        }

        public ScheduleTaskBuilder taskStatus(final Integer taskStatus) {
            this.taskStatus = taskStatus;
            return this;
        }

        public ScheduleTaskBuilder finishedTime(final LocalDateTime finishedTime) {
            this.finishedTime = finishedTime;
            return this;
        }

        public ScheduleTaskBuilder failReason(final String failReason) {
            this.failReason = failReason;
            return this;
        }

        public ScheduleTaskBuilder retryCount(final Integer retryCount) {
            this.retryCount = retryCount;
            return this;
        }

        public ScheduleTask build() {
            return new ScheduleTask(this.appId, this.groupId, this.groupCode, this.jobId, this.instanceIp, this.instancePort, this.taskStatus, this.finishedTime, this.failReason, this.retryCount);
        }

        public String toString() {
            return "ScheduleTask.ScheduleTaskBuilder(appId=" + this.appId + ", groupId=" + this.groupId + ", groupCode=" + this.groupCode + ", jobId=" + this.jobId + ", instanceIp=" + this.instanceIp + ", instancePort=" + this.instancePort + ", taskStatus=" + this.taskStatus + ", finishedTime=" + this.finishedTime + ", failReason=" + this.failReason + ", retryCount=" + this.retryCount + ")";
        }
    }
}
