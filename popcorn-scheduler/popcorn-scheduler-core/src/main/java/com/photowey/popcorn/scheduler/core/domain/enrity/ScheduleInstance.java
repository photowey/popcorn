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

/**
 * {@code ScheduleInstance}
 *
 * @author photowey
 * @date 2023/07/12
 * @since 1.0.0
 */
public class ScheduleInstance extends AbstractEntity<ScheduleInstance> implements Serializable {

    private static final long serialVersionUID = 1092906535164975821L;

    private Long appId;
    private Long groupId;
    private String instanceIp;
    private Integer instancePort;

    public static ScheduleInstanceBuilder builder() {
        return new ScheduleInstanceBuilder();
    }

    public Long getAppId() {
        return this.appId;
    }

    public Long getGroupId() {
        return this.groupId;
    }

    public String getInstanceIp() {
        return this.instanceIp;
    }

    public Integer getInstancePort() {
        return this.instancePort;
    }

    public void setAppId(final Long appId) {
        this.appId = appId;
    }

    public void setGroupId(final Long groupId) {
        this.groupId = groupId;
    }

    public void setInstanceIp(final String instanceIp) {
        this.instanceIp = instanceIp;
    }

    public void setInstancePort(final Integer instancePort) {
        this.instancePort = instancePort;
    }

    public ScheduleInstance() {
    }

    public ScheduleInstance(final Long appId, final Long groupId, final String instanceIp, final Integer instancePort) {
        this.appId = appId;
        this.groupId = groupId;
        this.instanceIp = instanceIp;
        this.instancePort = instancePort;
    }

    public static class ScheduleInstanceBuilder {
        private Long appId;
        private Long groupId;
        private String instanceIp;
        private Integer instancePort;

        ScheduleInstanceBuilder() {
        }

        public ScheduleInstanceBuilder appId(final Long appId) {
            this.appId = appId;
            return this;
        }

        public ScheduleInstanceBuilder groupId(final Long groupId) {
            this.groupId = groupId;
            return this;
        }

        public ScheduleInstanceBuilder instanceIp(final String instanceIp) {
            this.instanceIp = instanceIp;
            return this;
        }

        public ScheduleInstanceBuilder instancePort(final Integer instancePort) {
            this.instancePort = instancePort;
            return this;
        }

        public ScheduleInstance build() {
            return new ScheduleInstance(this.appId, this.groupId, this.instanceIp, this.instancePort);
        }

        public String toString() {
            return "ScheduleInstance.ScheduleInstanceBuilder(appId=" + this.appId + ", groupId=" + this.groupId + ", instanceIp=" + this.instanceIp + ", instancePort=" + this.instancePort + ")";
        }
    }
}
