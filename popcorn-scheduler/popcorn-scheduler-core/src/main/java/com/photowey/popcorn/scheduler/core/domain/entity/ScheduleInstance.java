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
 * {@code ScheduleInstance}
 *
 * @author photowey
 * @date 2023/07/12
 * @since 1.0.0
 */
public class ScheduleInstance extends AbstractEntity<ScheduleInstance> implements Serializable {

    private static final long serialVersionUID = 1092906535164975821L;

    /**
     * The ID of {@link ScheduleApp}
     */
    private Long appId;
    /**
     * The ID of {@link ScheduleGroup}
     */
    private Long groupId;
    /**
     * The IP of schedule instance and shared with client Spring Boot app.
     */
    private String instanceIp;
    /**
     * The port of schedule instance and shared with client Spring Boot app.
     */
    private Integer instancePort;
    /**
     * The protocol of RPC.
     */
    private String rpcProtocol;
    /**
     * The latest time of heartbeat.
     */
    private LocalDateTime heartbeatTime;

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

    public String getRpcProtocol() {
        return rpcProtocol;
    }

    public LocalDateTime getHeartbeatTime() {
        return this.heartbeatTime;
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

    public void setRpcProtocol(String rpcProtocol) {
        this.rpcProtocol = rpcProtocol;
    }

    public void setHeartbeatTime(final LocalDateTime heartbeatTime) {
        this.heartbeatTime = heartbeatTime;
    }

    public ScheduleInstance() {
    }

    public ScheduleInstance(final Long appId, final Long groupId, final String instanceIp, final Integer instancePort, final String rpcProtocol, final LocalDateTime heartbeatTime) {
        this.appId = appId;
        this.groupId = groupId;
        this.instanceIp = instanceIp;
        this.instancePort = instancePort;
        this.rpcProtocol = rpcProtocol;
        this.heartbeatTime = heartbeatTime;
    }

    public static class ScheduleInstanceBuilder {
        private Long appId;
        private Long groupId;
        private String instanceIp;
        private Integer instancePort;

        private String rpcProtocol;
        private LocalDateTime heartbeatTime;

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

        public ScheduleInstanceBuilder rpcProtocol(final String rpcProtocol) {
            this.rpcProtocol = rpcProtocol;
            return this;
        }

        public ScheduleInstanceBuilder heartbeatTime(final LocalDateTime heartbeatTime) {
            this.heartbeatTime = heartbeatTime;
            return this;
        }

        public ScheduleInstance build() {
            return new ScheduleInstance(this.appId, this.groupId, this.instanceIp, this.instancePort, this.rpcProtocol, this.heartbeatTime);
        }

        public String toString() {
            return "ScheduleInstance.ScheduleInstanceBuilder(appId=" + this.appId + ", groupId=" + this.groupId + ", instanceIp=" + this.instanceIp + ", instancePort=" + this.instancePort + ", rpcProtocol=" + this.rpcProtocol + ", heartbeatTime=" + this.heartbeatTime + ")";
        }
    }
}
