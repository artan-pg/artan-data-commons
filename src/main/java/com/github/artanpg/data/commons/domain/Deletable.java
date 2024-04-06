package com.github.artanpg.data.commons.domain;

import java.io.Serializable;

/**
 * Simple interface for record marked as deleted.
 *
 * @param <I> the type of the identifier
 * @author Mohammad Yazdian
 */
public interface Deletable<I extends Serializable> extends Persistable<I> {

    /**
     * Returns the record marked as deleted.
     *
     * @return true, if the record is marked as deleted
     */
    boolean isDeleted();

    /**
     * Sets the of record marked as deleted
     *
     * @param deleted the of the deleted flag to set
     */
    void setDeleted(boolean deleted);
}
