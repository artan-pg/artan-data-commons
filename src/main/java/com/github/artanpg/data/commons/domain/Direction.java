package com.github.artanpg.data.commons.domain;

import java.util.Objects;
import java.util.StringJoiner;

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
        if (Objects.isNull(value) || value.trim().isEmpty()) {
            throw new IllegalArgumentException("The entered value cannot be null or empty.");
        }
        for (Direction direction : values()) {
            if (direction.name().equalsIgnoreCase(value)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("The entered value is not valid.");
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Direction.class.getSimpleName() + "[", "]")
                .toString();
    }
}
