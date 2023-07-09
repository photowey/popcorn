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
package com.photowey.popcorn.starting.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * {@code AppPrinter}
 *
 * @author photowey
 * @date 2023/07/08
 * @since 1.0.0
 */
public final class AppPrinter implements Printer {

    private static final Logger log = LoggerFactory.getLogger(AppPrinter.class);

    public static void print(ConfigurableApplicationContext applicationContext) {
        print(applicationContext, true);
    }

    public static void print(ConfigurableApplicationContext applicationContext, boolean swagger) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        print(applicationContext, swagger, () -> Optional
                .ofNullable(environment.getProperty(SERVLET_CONTEXT_PATH))
                .filter(StringUtils::hasText)
                .orElse(""));
    }

    public static void print(ConfigurableApplicationContext applicationContext, boolean swagger, Supplier<String> contextPathFunc) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String protocol = Optional.ofNullable(environment.getProperty(SERVER_SSL_KEY)).map(key -> HTTPS).orElse(HTTP);

        String app = environment.getProperty(APPLICATION_NAME);
        String port = environment.getProperty(SERVER_PORT);

        String[] profileActive = environment.getActiveProfiles().length == 0
                ? environment.getDefaultProfiles()
                : environment.getActiveProfiles();

        String host = "localhost";
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }

        String contextPath = contextPathFunc.get();
        String healthContextPath = Optional
                .ofNullable(environment.getProperty(SERVLET_CONTEXT_PATH))
                .filter(StringUtils::hasText)
                .orElse("");

        if (swagger) {
            withSwagger(protocol, app, port, profileActive, host, contextPath, healthContextPath);
        } else {
            withoutSwagger(protocol, app, port, profileActive, host, contextPath, healthContextPath);
        }
    }

    private static void withoutSwagger(
            String protocol, String app, String port,
            String[] profileActive, String host, String contextPath, String healthContextPath) {
        log.info("\n----------------------------------------------------------\n\t" +
                        "Bootstrap: the '{}' is Success!\n\t" +
                        "Application: '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "Healthz: \t{}://{}:{}{}/healthz\n\t" +
                        "Actuator: \t{}://{}:{}{}/actuator/health\n\t" +
                        "Profile(s): {}\n----------------------------------------------------------",
                app + " Context",
                app,
                protocol, port, contextPath,
                protocol, host, port, contextPath,
                protocol, host, port, contextPath,
                protocol, host, port, healthContextPath,
                profileActive
        );
    }

    private static void withSwagger(
            String protocol, String app, String port,
            String[] profileActive, String host, String contextPath, String healthContextPath) {
        log.info("\n----------------------------------------------------------\n\t" +
                        "Bootstrap: the '{}' is Success!\n\t" +
                        "Application: '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "Swagger: \t{}://{}:{}{}/doc.html\n\t" +
                        "Healthz: \t{}://{}:{}{}/healthz\n\t" +
                        "Actuator: \t{}://{}:{}{}/actuator/health\n\t" +
                        "Profile(s): {}\n----------------------------------------------------------",
                app + " Context",
                app,
                protocol, port, contextPath,
                protocol, host, port, contextPath,
                protocol, host, port, contextPath,
                protocol, host, port, contextPath,
                protocol, host, port, healthContextPath,
                profileActive
        );
    }
}