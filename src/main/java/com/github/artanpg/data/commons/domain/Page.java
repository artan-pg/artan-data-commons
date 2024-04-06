package com.github.artanpg.data.commons.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Simple interface for pagination a query result set.
 *
 * @param <T> the type of the found result set
 * @author Mohammad Yazdian
 */
public interface Page<T> extends Iterable<T>, Serializable {

    /**
     * Returns the number of the current {@link Page}.
     *
     * @return the number of the current {@link Page}
     */
    int getPageNumber();

    /**
     * Returns the size of the {@link Page}.
     *
     * @return the size of the {@link Page}.
     */
    int getPageSize();

    /**
     * Returns the ordered parameters for the {@link Page}.
     *
     * @return the ordered parameters for the {@link Page}
     */
    Orders getOrders();

    /**
     * Returns the number of total pages.
     *
     * @return the number of total pages
     */
    long getTotalPageNumber();

    /**
     * Returns the total number of entities found.
     *
     * @return total number of entities found
     */
    long getTotalElements();

    /**
     * Returns the page content as {@link List}.
     *
     * @return the page content as {@link List}
     */
    List<T> getContent();

    /**
     * Returns whether the {@link Page} has content at all.
     *
     * @return true, if the {@link Page} has content
     */
    boolean hasContent();

    /**
     * Returns whether the current {@link Page} is the first one.
     *
     * @return true, if the current {@link Page} is the first one
     */
    boolean isFirstPage();

    /**
     * Returns whether the current {@link Page} is the last one.
     *
     * @return ture, if the current {@link Page} is the last one
     */
    boolean isLastPage();

    /**
     * Returns if there is a next {@link Page}.
     *
     * @return true, if there is a next {@link Page}.
     */
    boolean hasNextPage();

    /**
     * Returns if there is a previous {@link Page}.
     *
     * @return true, if there is a previous {@link Page}.
     */
    boolean hasPreviousPage();

}
