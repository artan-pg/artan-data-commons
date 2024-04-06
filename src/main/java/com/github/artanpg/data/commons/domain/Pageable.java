package com.github.artanpg.data.commons.domain;

import java.io.Serializable;

/**
 * Simple interface for pagination information.
 *
 * @author Mohammad Yazdian
 */
public interface Pageable extends Serializable {

    /**
     * Returns the current page number.
     *
     * @return current page number
     */
    int getPageNumber();

    /**
     * Return the size of the page.
     *
     * @return the size of the page
     */
    int getPageSize();

    /**
     * Returns the ordering parameter.
     *
     * @return the ordering parameter
     */
    Orders getOrders();
}
