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
package com.photowey.popcorn.server;

import com.photowey.popcorn.autoconfigure.starter.AppStarter;
import com.photowey.popcorn.starting.printer.AppPrinter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@code App}
 *
 * @author photowey
 * @date 2023/07/08
 * @since 1.0.0
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        headless(args);
        runApp(args);
    }

    private static void headless(String[] args) {
        System.setProperty("java.awt.headless", "true");
    }

    private static void runApp(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);
        report(applicationContext);
    }

    private static void report(ConfigurableApplicationContext applicationContext) {
        AppPrinter.print(applicationContext, false);
        AppStarter.started(applicationContext);
    }
}
