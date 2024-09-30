/*
 * Copyright 2024-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.artanpg.data.commons.domain;

import java.io.Serializable;

/**
 * Simple interface for entities.
 *
 * @param <I> the type of the identifier
 * @author Mohammad Yazdian
 */
public interface Persistable<I extends Serializable> extends Serializable {

    /**
     * Gets the id of the entity.
     *
     * @return the id of the entity
     */
    I getId();

    /**
     * Check the current state of the entity.
     *
     * @return true, if the entity is new
     */
    boolean checkNewRecord();
}
