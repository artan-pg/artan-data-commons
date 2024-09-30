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

import com.github.artanpg.core.utils.Asserts;

/**
 * Enumeration for null handling hints that can be used in query result sets
 * ordered by an <strong>ORDER BY</strong> clause.
 *
 * @author Mohammad Yazdian
 */
public enum NullHandling {

    NONE,
    FIRST,
    LAST;

    /**
     * Interprets a string representation of a NullPrecedence.
     *
     * @param value The String representation to interpret
     * @return The recognized NullHandling
     */
    public static NullHandling parse(String value) {
        Asserts.hasText(value, "The entered value cannot be null or empty");

        for (NullHandling nullHandling : values()) {
            if (nullHandling.name().equalsIgnoreCase(value)) {
                return nullHandling;
            }
        }

        throw new IllegalArgumentException("The entered value is not valid");
    }
}
