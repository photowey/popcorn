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
package com.photowey.popcorn.logging.initializer;

import com.photowey.popcorn.logging.logback.TimeRollingFileInstaller;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.boot.logging.logback.LogbackLoggingSystem;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

/**
 * {@code TimeRollingLoggingApplicationInitializer}
 *
 * @author photowey
 * @date 2023/07/08
 * @since 1.0.0
 */
public class TimeRollingLoggingApplicationInitializer implements
        ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {

    private static final String DEFAULT_LOGGING_CONFIG_FILE_NAMES_KEY = "SPRING_POPCORN_LOGGING_LOGBACK_CONFIG_FILE_LOCATIONS";
    private static final int INITIALIZER_ORDER = Ordered.HIGHEST_PRECEDENCE + 20;

    private static final String[] DEFAULT_LOGGING_CONFIG_FILE_NAMES = new String[]{
            "logback.xml",
            "logback-dev.xml",
            "logback-test.xml",
            "logback-prod.xml",
            "logback-spring.xml"
    };

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        if (this.determineShouldShip()) {
            return;
        }

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        TimeRollingFileInstaller installer = new TimeRollingFileInstaller(environment);
        installer.install();
    }

    @Override
    public int getOrder() {
        return INITIALIZER_ORDER;
    }

    private boolean determineShouldShip() {
        return this.isNotLogback() || this.hasResourceConfigurer();
    }

    private boolean isNotLogback() {
        return !this.isLogback();
    }

    private boolean isLogback() {
        LoggingSystem loggingSystem = LoggingSystem.get(TimeRollingLoggingApplicationInitializer.class.getClassLoader());
        return loggingSystem instanceof LogbackLoggingSystem;
    }

    private Boolean hasResourceConfigurer() {
        String[] configFiles = this.determineLoggingConfigFiles();

        for (String configFile : configFiles) {
            Resource resource = new ClassPathResource(configFile, this.getClass().getClassLoader());
            if (resource.exists()) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    private String[] determineLoggingConfigFiles() {
        String configValues = System.getenv(DEFAULT_LOGGING_CONFIG_FILE_NAMES_KEY);
        if (StringUtils.hasLength(configValues)) {
            return StringUtils.tokenizeToStringArray(configValues, ",");
        }

        return DEFAULT_LOGGING_CONFIG_FILE_NAMES;
    }
}
