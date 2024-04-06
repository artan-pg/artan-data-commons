package com.github.artanpg.data.commons.domain;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Basic Java Bean implementation of {@link Page}.
 *
 * @param <T> the type of the found result set
 * @author Mohammad Yazdian
 */
public class PageImpl<T> implements Page<T> {
    @Serial
    private static final long serialVersionUID = -1120354970066276174L;

    private final Pageable pageable;
    private final List<T> content = new ArrayList<>();
    private final int total;

    private PageImpl(List<T> content) {
        this(content, null);
    }

    private PageImpl(List<T> content, Pageable pageable) {
        if (Objects.isNull(content)) {
            throw new IllegalArgumentException("Content must not be null.");
        }

        this.content.addAll(content);
        this.pageable = pageable;
        this.total = content.size();
    }

    /**
     * Creates a new instance of {@link PageImpl}.
     *
     * @param content the content of this page
     * @return An instance of a {@link PageImpl} object
     */
    public static <T> Page<T> of(List<T> content) {
        return new PageImpl<>(content);
    }

    /**
     * Creates a new instance of {@link PageImpl}.
     *
     * @param content  the content of this page
     * @param pageable the paging information
     * @return An instance of a {@link PageImpl} object
     */
    public static <T> Page<T> of(List<T> content, Pageable pageable) {
        return new PageImpl<>(content, pageable);
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
        PageImpl<?> page = (PageImpl<?>) o;
        return total == page.total &&
                Objects.equals(pageable, page.pageable) &&
                Objects.equals(content, page.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageable, content, total);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PageImpl.class.getSimpleName() + "[", "]")
                .add("pageable=" + pageable)
                .add("content=" + content)
                .add("total=" + total)
                .toString();
    }
}
