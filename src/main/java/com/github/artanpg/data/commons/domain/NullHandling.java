package com.github.artanpg.data.commons.domain;

import java.util.Objects;

/**
 * Enumeration for null handling hints that can be used in query
 * result sets ordered by an <strong>ORDER BY</strong> clause.
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
        if (Objects.isNull(value) || value.trim().isEmpty()) {
            throw new IllegalArgumentException("The entered value cannot be null or empty.");
        }
        for (NullHandling nullHandling : values()) {
            if (nullHandling.name().equalsIgnoreCase(value)) {
                return nullHandling;
            }
        }
        throw new IllegalArgumentException("The entered value is not valid.");
    }
}
