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
package com.photowey.popcorn.scheduler.core.domain.payload;

import java.io.Serializable;
import java.util.Objects;

/**
 * {@code AppRegisterPayload}
 *
 * @author photowey
 * @date 2023/07/27
 * @since 1.0.0
 */
public class AppRegisterPayload implements Serializable {

    /**
     * App code.
     */
    private String appCode;
    /**
     * App name.
     */
    private String appName;

    public static AppRegisterPayloadBuilder builder() {
        return new AppRegisterPayloadBuilder();
    }

    public String getAppCode() {
        return this.appCode;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppCode(final String appCode) {
        this.appCode = appCode;
    }

    public void setAppName(final String appName) {
        this.appName = appName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppRegisterPayload)) return false;
        AppRegisterPayload that = (AppRegisterPayload) o;
        return Objects.equals(getAppCode(), that.getAppCode()) && Objects.equals(getAppName(), that.getAppName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAppCode(), getAppName());
    }

    @Override
    public String toString() {
        return "AppRegisterPayload{" +
                "appCode='" + appCode + '\'' +
                ", appName='" + appName + '\'' +
                '}';
    }

    public AppRegisterPayload() {
    }

    public AppRegisterPayload(final String appCode, final String appName) {
        this.appCode = appCode;
        this.appName = appName;
    }

    public static class AppRegisterPayloadBuilder {
        private String appCode;
        private String appName;

        AppRegisterPayloadBuilder() {
        }

        public AppRegisterPayloadBuilder appCode(final String appCode) {
            this.appCode = appCode;
            return this;
        }

        public AppRegisterPayloadBuilder appName(final String appName) {
            this.appName = appName;
            return this;
        }

        public AppRegisterPayload build() {
            return new AppRegisterPayload(this.appCode, this.appName);
        }

        public String toString() {
            return "AppRegisterPayload.AppRegisterPayloadBuilder(appCode=" + this.appCode + ", appName=" + this.appName + ")";
        }
    }
}
