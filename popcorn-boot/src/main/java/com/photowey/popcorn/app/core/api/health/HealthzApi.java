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
package com.photowey.popcorn.app.core.api.health;

import com.photowey.popcorn.app.core.getter.EnvironmentGetter;
import com.photowey.popcorn.common.formatter.text.StringFormatter;
import com.photowey.popcorn.core.constant.PopcornConstants;

/**
 * {@code HealthzApi}
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
public interface HealthzApi extends EnvironmentGetter {

    /**
     * Determine custom health-api path {@code `/healthz`}.
     *
     * @return the path of custom health-api.
     */
    default String determineHealthzApi() {
        String template = PopcornConstants.STRING_DEFAULT_HEALTH_API_TEMPLATE;
        String port = this.environment().getProperty(
                EnvironmentGetter.APPLICATION_SERVER_PORT_KEY, PopcornConstants.STRING_DEFAULT_SERVER_PORT);
        String ctxPath = this.environment().getProperty(
                EnvironmentGetter.APPLICATION_SERVER_SERVLET_CONTEXT_PATH_KEY, PopcornConstants.STRING_DEFAULT_SERVER_SERVLET_CONTENT_PATH);

        return StringFormatter.format(template, port, ctxPath.startsWith(PopcornConstants.STRING_SLASH)
                ? ctxPath :
                PopcornConstants.STRING_SLASH + ctxPath);
    }
}
