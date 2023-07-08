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
package com.photowey.popcorn.logging.listener;

import com.photowey.popcorn.starting.listener.builtin.AbstractApplicationStartingEventListener;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {@code InjectAppHomePropertyApplicationListener}
 *
 * @author photowey
 * @date 2023/07/08
 * @since 1.0.0
 */
public class InjectAppHomePropertyApplicationListener extends AbstractApplicationStartingEventListener implements EnvironmentAware, Ordered {

    private static final int DEFAULT_ORDER = Ordered.HIGHEST_PRECEDENCE;
    private static final String APP_HOME_KEY = "app.home";
    private static final String SLASH = "/";
    private static final String CLASSPATH = "";

    private static final String[] SUPPORT_FILE_TYPES = new String[]{
            "(file:)?(.*/).*\\.jar!.*",
            "(file:)?(.*/target/)test-classes.*",
            "(file:)?(.*/target/)classes.*",
    };

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void onEvent(ApplicationStartingEvent event) {
        this.tryInitAppHome();
    }

    protected void tryInitAppHome() {
        String path = this.getClass().getClassLoader().getResource(CLASSPATH).getPath();
        try {
            path = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
        } catch (Exception ignored) {
        }

        for (String support : SUPPORT_FILE_TYPES) {
            Matcher matcher = Pattern.compile(support).matcher(path);
            if (matcher.matches()) {
                path = matcher.group(2);
                break;
            }
        }

        if (path.endsWith(SLASH)) {
            path = path.substring(0, path.length() - 1);
        }

        System.setProperty(APP_HOME_KEY, path);
    }

    @Override
    public int getOrder() {
        return DEFAULT_ORDER;
    }

}
