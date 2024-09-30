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
     * Gets the number of the current {@link Page}.
     *
     * @return the number of the current {@link Page}
     */
    int getPageNumber();

    /**
     * Gets the size of the {@link Page}.
     *
     * @return the size of the {@link Page}.
     */
    int getPageSize();

    /**
     * Gets the ordered parameters for the {@link Page}.
     *
     * @return the ordered parameters for the {@link Page}
     */
    Orders getOrders();

    /**
     * Gets the number of total pages.
     *
     * @return the number of total pages
     */
    long getTotalPageNumber();

    /**
     * Gets the total number of entities found.
     *
     * @return total number of entities found
     */
    long getTotalElements();

    /**
     * Gets the page content as {@link List}.
     *
     * @return the page content as {@link List}
     */
    List<T> getContent();

    /**
     * Checks whether the {@link Page} has content at all.
     *
     * @return true, if the {@link Page} has content, otherwise false
     */
    boolean hasContent();

    /**
     * Checks whether the current {@link Page} is the first one.
     *
     * @return true, if the current {@link Page} is the first one. otherwise false
     */
    boolean isFirstPage();

    /**
     * Checks whether the current {@link Page} is the last one.
     *
     * @return ture, if the current {@link Page} is the last one, otherwise false
     */
    boolean isLastPage();

    /**
     * Checks if there is a next {@link Page}.
     *
     * @return true, if there is a next {@link Page}, otherwise false
     */
    boolean hasNextPage();

    /**
     * Checks if there is a previous {@link Page}.
     *
     * @return true, if there is a previous {@link Page}, otherwise false
     */
    boolean hasPreviousPage();
}
