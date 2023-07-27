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
package com.photowey.popcorn.scheduler.core.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;

/**
 * {@code AppRegisterDTO}
 *
 * @author photowey
 * @date 2023/07/27
 * @since 1.0.0
 */
public class AppRegisterDTO implements Serializable {

    private static final long serialVersionUID = 1377734748812623706L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long appId;

    private String appCode;
    private String appName;

    /**
     * Client ID for login.
     */
    private String clientId;
    /**
     * Client secret for login.
     */
    private String clientSecret;

    public static AppRegisterDTOBuilder builder() {
        return new AppRegisterDTOBuilder();
    }

    public Long getAppId() {
        return this.appId;
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

    public void setAppId(final Long appId) {
        this.appId = appId;
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

    public AppRegisterDTO() {
    }

    public AppRegisterDTO(final Long appId, final String appCode, final String appName, final String clientId, final String clientSecret) {
        this.appId = appId;
        this.appCode = appCode;
        this.appName = appName;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public static class AppRegisterDTOBuilder {

        private Long appId;
        private String appCode;
        private String appName;
        private String clientId;
        private String clientSecret;

        AppRegisterDTOBuilder() {
        }

        public AppRegisterDTOBuilder appId(final Long appId) {
            this.appId = appId;
            return this;
        }

        public AppRegisterDTOBuilder appCode(final String appCode) {
            this.appCode = appCode;
            return this;
        }

        public AppRegisterDTOBuilder appName(final String appName) {
            this.appName = appName;
            return this;
        }

        public AppRegisterDTOBuilder clientId(final String clientId) {
            this.clientId = clientId;
            return this;
        }

        public AppRegisterDTOBuilder clientSecret(final String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public AppRegisterDTO build() {
            return new AppRegisterDTO(this.appId, this.appCode, this.appName, this.clientId, this.clientSecret);
        }

        public String toString() {
            return "AppRegisterDTO.AppRegisterDTOBuilder(appId=" + this.appId + ", appCode=" + this.appCode + ", appName=" + this.appName + ", clientId=" + this.clientId + ", clientSecret=" + this.clientSecret + ")";
        }
    }

}
