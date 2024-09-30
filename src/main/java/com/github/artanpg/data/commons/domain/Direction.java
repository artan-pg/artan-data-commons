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
 * Enumerates the directions in which query results may be ordered.
 *
 * @author Mohammad Yazdian
 */
public enum Direction {

    ASC,
    DESC;

    /**
     * Checks if the direction is ascending.
     *
     * @return true, if the direction is ascending
     */
    public boolean isAscending() {
        return this.equals(ASC);
    }

    /**
     * Checks if the direction is descending.
     *
     * @return true, if the direction is descending
     */
    public boolean isDescending() {
        return this.equals(DESC);
    }

    /**
     * Interprets a string representation of a Direction.
     *
     * @param value The String representation to interpret
     * @return The recognized Direction
     */
    public static Direction parse(String value) {
        Asserts.hasText(value, "The entered value cannot be null or empty");

        for (Direction direction : values()) {
            if (direction.name().equalsIgnoreCase(value)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("The entered value is not valid");
    }
}
