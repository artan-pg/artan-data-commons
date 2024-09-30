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

import com.github.artanpg.core.utils.builder.EqualsBuilder;
import com.github.artanpg.core.utils.builder.HashCodeBuilder;
import com.github.artanpg.core.utils.builder.ToStringBuilder;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Default Java Bean implementation of {@link Page}.
 *
 * @param <T> the type of the found result set
 * @author Mohammad Yazdian
 */
public class DefaultPage<T> implements Page<T> {

    @Serial
    private static final long serialVersionUID = -1120354970066276174L;

    private final Pageable pageable;
    private final List<T> content = new ArrayList<>();
    private final int total;

    private DefaultPage(List<T> content) {
        this(content, null);
    }

    private DefaultPage(List<T> content, Pageable pageable) {
        if (Objects.isNull(content)) {
            throw new IllegalArgumentException("Content must not be null.");
        }

        this.content.addAll(content);
        this.pageable = pageable;
        this.total = content.size();
    }

    /**
     * Creates a new instance of {@link DefaultPage}.
     *
     * @param content the content of this page
     * @return An instance of a {@link DefaultPage} object
     */
    public static <T> Page<T> of(List<T> content) {
        return new DefaultPage<>(content);
    }

    /**
     * Creates a new instance of {@link DefaultPage}.
     *
     * @param content  the content of this page
     * @param pageable the paging information
     * @return An instance of a {@link DefaultPage} object
     */
    public static <T> Page<T> of(List<T> content, Pageable pageable) {
        return new DefaultPage<>(content, pageable);
    }

    @Override
    public int getPageNumber() {
        return Objects.isNull(pageable) ? 0 : pageable.getPageNumber();
    }

    @Override
    public int getPageSize() {
        return Objects.isNull(pageable) ? 0 : pageable.getPageSize();
    }

    @Override
    public Orders getOrders() {
        return Objects.isNull(pageable) ? null : pageable.getOrders();
    }

    @Override
    public long getTotalPageNumber() {
        return (int) Math.ceil((double) total / getPageSize());
    }

    @Override
    public long getTotalElements() {
        return total;
    }

    @Override
    public List<T> getContent() {
        return content;
    }

    @Override
    public boolean hasContent() {
        return !content.isEmpty();
    }

    @Override
    public boolean isFirstPage() {
        return !hasPreviousPage();
    }

    @Override
    public boolean isLastPage() {
        return !hasNextPage();
    }

    @Override
    public boolean hasNextPage() {
        return ((getPageNumber() + 1) * getPageSize()) < total;
    }

    @Override
    public boolean hasPreviousPage() {
        return getPageNumber() > 0;
    }

    @Override
    public Iterator<T> iterator() {
        return content.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        DefaultPage<?> that = (DefaultPage<?>) o;

        return EqualsBuilder.of()
                .append(total, that.total)
                .append(pageable, that.pageable)
                .append(content, that.content)
                .build();
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.of()
                .append(pageable)
                .append(content)
                .append(total)
                .build();
    }

    @Override
    public String toString() {
        return ToStringBuilder.jsonStyle()
                .append("pageable", pageable)
                .append("content", content)
                .append("total", total)
                .build();
    }
}
