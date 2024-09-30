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
import com.github.artanpg.core.utils.builder.EqualsBuilder;
import com.github.artanpg.core.utils.builder.HashCodeBuilder;
import com.github.artanpg.core.utils.builder.ToStringBuilder;

import java.io.Serial;

/**
 * Default Java Bean implementation of {@link Pageable}.
 *
 * @author Mohammad Yazdian
 */
public class DefaultPageable implements Pageable {

    @Serial
    private static final long serialVersionUID = 1042959938136228220L;

    private final int pageNumber;
    private final int pageSize;
    private final Orders orders;

    private DefaultPageable(int pageNumber, int pageSize) {
        this(pageNumber, pageSize, null);
    }

    private DefaultPageable(int pageNumber, int pageSize, Orders orders) {
        Asserts.isFalse(pageNumber < 0, "Page number must not be less than zero");
        Asserts.isFalse(pageSize < 1, "Page size must not be less than one");

        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.orders = orders;
    }

    /**
     * Creates a new unsorted {@link DefaultPageable}.
     *
     * @param pageNumber zero-based page number
     * @param pageSize   the size of the page to be returned
     * @return An instance of a {@link DefaultPageable} object
     */
    public static DefaultPageable of(int pageNumber, int pageSize) {
        return new DefaultPageable(pageNumber, pageSize);
    }

    /**
     * Creates a new {@link DefaultPageable} with ordered parameters applied.
     *
     * @param pageNumber zero-based page number
     * @param pageSize   the size of the page to be returned
     * @param orders     must not be {@literal null}
     * @return An instance of a {@link DefaultPageable} object
     */
    public static DefaultPageable of(int pageNumber, int pageSize, Orders orders) {
        return new DefaultPageable(pageNumber, pageSize, orders);
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public Orders getOrders() {
        return orders;
    }

    /**
     * Returns the offset to be taken according to the underlying
     * page and page size.
     *
     * @return the offset to be taken
     */
    public long getOffset() {
        return (long) pageNumber * (long) pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        DefaultPageable that = (DefaultPageable) o;

        return EqualsBuilder.of()
                .append(pageNumber, that.pageNumber)
                .append(pageSize, that.pageSize)
                .append(orders, that.orders)
                .build();
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.of()
                .append(pageNumber)
                .append(pageSize)
                .append(orders)
                .toHashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.jsonStyle()
                .append("pageNumber", pageNumber)
                .append("pageSize", pageSize)
                .append("orders", orders)
                .build();
    }
}
