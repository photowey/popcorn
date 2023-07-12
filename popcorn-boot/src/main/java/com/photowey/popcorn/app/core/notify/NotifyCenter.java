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
package com.photowey.popcorn.app.core.notify;

import com.photowey.popcorn.app.core.aware.FlexibleApplicationContextAware;
import com.photowey.popcorn.app.core.aware.FlexibleBeanFactoryAware;
import org.springframework.context.ApplicationEvent;

/**
 * {@code NotifyCenter}
 *
 * @author photowey
 * @date 2023/07/08
 * @since 1.0.0
 */
public interface NotifyCenter extends FlexibleBeanFactoryAware, FlexibleApplicationContextAware {

    <T extends ApplicationEvent> void publishEvent(T event);
}