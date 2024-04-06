package com.github.artanpg.data.commons.domain;

import java.io.Serial;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Basic Java Bean implementation of {@link Pageable}.
 *
 * @author Mohammad Yazdian
 */
public class PageableImpl implements Pageable {
    @Serial
    private static final long serialVersionUID = 1042959938136228220L;

    private final int pageNumber;
    private final int pageSize;
    private final Orders orders;

    private PageableImpl(int pageNumber, int pageSize) {
        this(pageNumber, pageSize, null);
    }

    private PageableImpl(int pageNumber, int pageSize, Orders orders) {
        if (pageNumber < 0) {
            throw new IllegalArgumentException("Page number must not be less than zero.");
        }
        if (pageSize < 1) {
            throw new IllegalArgumentException("Page size must not be less than one.");
        }

        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.orders = orders;
    }

    /**
     * Creates a new unsorted {@link PageableImpl}.
     *
     * @param pageNumber zero-based page number
     * @param pageSize   the size of the page to be returned
     * @return An instance of a {@link PageableImpl} object
     */
    public static PageableImpl of(int pageNumber, int pageSize) {
        return new PageableImpl(pageNumber, pageSize);
    }

    /**
     * Creates a new {@link PageableImpl} with ordered parameters applied.
     *
     * @param pageNumber zero-based page number
     * @param pageSize   the size of the page to be returned
     * @param orders     must not be {@literal null}
     * @return An instance of a {@link PageableImpl} object
     */
    public static PageableImpl of(int pageNumber, int pageSize, Orders orders) {
        return new PageableImpl(pageNumber, pageSize, orders);
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
        PageableImpl pageable = (PageableImpl) o;
        return pageNumber == pageable.pageNumber &&
                pageSize == pageable.pageSize &&
                Objects.equals(orders, pageable.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNumber, pageSize, orders);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PageableImpl.class.getSimpleName() + "[", "]")
                .add("pageNumber=" + pageNumber)
                .add("pageSize=" + pageSize)
                .add("orders=" + orders)
                .toString();
    }
}
