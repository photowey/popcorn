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

/**
 * {@code ScheduleApp}
 *
 * @author photowey
 * @date 2023/07/12
 * @since 1.0.0
 */
public class ScheduleApp extends AbstractEntity<ScheduleApp> implements Serializable {

    private static final long serialVersionUID = 4258397574249360394L;

    private String appCode;
    private String appName;
    private String clientId;
    private String clientSecret;

    public static ScheduleAppBuilder builder() {
        return new ScheduleAppBuilder();
    }

    public String getAppCode() {
        return this.appCode;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientSecret() {
        return this.clientSecret;
    }

    public void setAppCode(final String appCode) {
        this.appCode = appCode;
    }

    public void setAppName(final String appName) {
        this.appName = appName;
    }

    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(final String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public ScheduleApp() {
    }

    public ScheduleApp(final String appCode, final String appName, final String clientId, final String clientSecret) {
        this.appCode = appCode;
        this.appName = appName;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public static class ScheduleAppBuilder {
        private String appCode;
        private String appName;
        private String clientId;
        private String clientSecret;

        ScheduleAppBuilder() {
        }

        public ScheduleAppBuilder appCode(final String appCode) {
            this.appCode = appCode;
            return this;
        }

        public ScheduleAppBuilder appName(final String appName) {
            this.appName = appName;
            return this;
        }

        public ScheduleAppBuilder clientId(final String clientId) {
            this.clientId = clientId;
            return this;
        }

        public ScheduleAppBuilder clientSecret(final String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public ScheduleApp build() {
            return new ScheduleApp(this.appCode, this.appName, this.clientId, this.clientSecret);
        }

        public String toString() {
            return "ScheduleApp.ScheduleAppBuilder(appCode=" + this.appCode + ", appName=" + this.appName + ", clientId=" + this.clientId + ", clientSecret=" + this.clientSecret + ")";
        }
    }
}
