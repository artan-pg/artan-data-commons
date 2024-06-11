package com.github.artanpg.data.commons.domain;

import java.io.Serializable;

/**
 * Simple interface for entities.
 *
 * @param <I> the type of the identifier
 * @author Mohammad Yazdian
 */
public interface Persistable<I extends Serializable> extends Serializable {

    /**
     * Returns the id of the entity.
     *
     * @return the id of the entity
     */
    I getId();

    /**
     * Returns the current state of the entity.
     *
     * @return true, if the entity is new
     */
    boolean newRecord();
}
