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
package com.photowey.popcorn.autoconfigure.property;

import java.io.Serializable;

/**
 * {@code PopcornServerProperties}
 *
 * @author photowey
 * @date 2023/07/10
 * @since 1.0.0
 */
public class PopcornServerProperties implements Serializable {

    private static final String POPCORN_SERVER_PROPERTY_PREFIX = "spring.schedule.popcorn.server";

    public static String getPrefix() {
        return POPCORN_SERVER_PROPERTY_PREFIX;
    }

    private Scheduler scheduler = new Scheduler();

    // ----------------------------------------------------------------

    public static class Scheduler implements Serializable {

        private static final long serialVersionUID = -537311943221162412L;

        private Kernel kernel = new Kernel();

        public Kernel getKernel() {
            return kernel;
        }

        public void setKernel(Kernel kernel) {
            this.kernel = kernel;
        }
    }

    public static class Kernel implements Serializable {

        private static final long serialVersionUID = 4400870242462157237L;

        private Database database = new Database();
        private Mongo mongo = new Mongo();

        public Database getDatabase() {
            return database;
        }

        public void setDatabase(Database database) {
            this.database = database;
        }

        public Mongo getMongo() {
            return mongo;
        }

        public void setMongo(Mongo mongo) {
            this.mongo = mongo;
        }
    }

    public static class Database implements Serializable {

        private static final long serialVersionUID = -9026798333178165460L;

        private boolean enabled = true;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }

    public static class Mongo implements Serializable {

        private static final long serialVersionUID = -5024794877138503201L;

        private boolean enabled = false;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }

    // ----------------------------------------------------------------

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
