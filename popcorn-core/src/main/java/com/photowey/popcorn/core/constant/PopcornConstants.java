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
package com.photowey.popcorn.core.constant;

/**
 * {@code PopcornConstants}
 *
 * @author photowey
 * @date 2023/07/09
 * @since 1.0.0
 */
public interface PopcornConstants {

    // ---------------------------------------------------------------- Int

    int INT_DEFAULT_SERVER_PORT = 9320;

    // ---------------------------------------------------------------- Long

    // ---------------------------------------------------------------- String

    String STRING_SLASH = "/";
    String STRING_DEFAULT_HEALTH_API_TEMPLATE = "http://127.0.0.1:{}{}/healthz";
    String STRING_DEFAULT_SERVER_PORT = String.valueOf(INT_DEFAULT_SERVER_PORT);
    String STRING_DEFAULT_SERVER_SERVLET_CONTENT_PATH = "/popcorn";

}
