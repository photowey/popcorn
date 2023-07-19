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
package com.photowey.popcorn.server.property;

import com.photowey.popcorn.autoconfigure.engine.root.PopcornEngine;
import com.photowey.popcorn.autoconfigure.property.PopcornProperties;
import com.photowey.popcorn.autoconfigure.property.PopcornServerProperties;
import com.photowey.popcorn.server.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * {@code PropertiesTest}
 *
 * @author photowey
 * @date 2023/07/16
 * @since 1.0.0
 */
@SpringBootTest(classes = App.class)
class PropertiesTest {

    @Autowired
    private PopcornEngine popcornEngine;

    @Test
    void testPropertyBinding() {
        PopcornProperties popcornProperties = this.popcornEngine.propertyEngine().popcornProperties();

        Assertions.assertEquals("1.0.0", popcornProperties.getVersion());
    }

    @Test
    void testServerPropertyBinding() {
        PopcornServerProperties popcornServerProperties = this.popcornEngine.propertyEngine().popcornServerProperties();

        Assertions.assertTrue(popcornServerProperties.getScheduler().getKernel().getDatabase().isEnabled());
        Assertions.assertFalse(popcornServerProperties.getScheduler().getKernel().getMongo().isEnabled());
    }
}
