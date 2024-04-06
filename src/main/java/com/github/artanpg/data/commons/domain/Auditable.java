package com.github.artanpg.data.commons.domain;

import java.io.Serializable;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

/**
 * Simple interface for auditable entities. Allows storing and
 * retrieving creation and modification information.
 *
 * @param <E> the type of the auditing. Typically, user entity or id.
 * @param <I> the type of the identifier
 * @author Mohammad Yazdian
 */
public interface Auditable<E, I extends Serializable> extends Persistable<I> {

    /**
     * Sets the object who created entity.
     *
     * @param createdBy the object to set
     */
    void setCreatedBy(E createdBy);

    /**
     * Returns the object who created entity.
     *
     * @return the object who created entity
     */
    E getCreatedBy();

    /**
     * Sets the creation date of the entity.
     *
     * @param creationDate the creation date
     */
    void setCreatedDate(TemporalAccessor creationDate);

    /**
     * Returns the creation date of the entity.
     *
     * @return the creation date of the entity
     */
    TemporalAccessor getCreatedDate();

    /**
     * Sets the object who modified the entity lastly.
     *
     * @param lastModifiedBy the object to set
     */
    void setLastModifiedBy(E lastModifiedBy);

    /**
     * Returns the object who modified the entity lastly.
     *
     * @return the object who modified this entity lastly
     */
    Optional<E> getLastModifiedBy();

    /**
     * Sets the date of the entity last modification.
     *
     * @param lastModifiedDate the last modification date
     */
    void setLastModifiedDate(TemporalAccessor lastModifiedDate);

    /**
     * Returns the date of the entity last modification.
     *
     * @return the date of the entity last modification
     */
    Optional<TemporalAccessor> getLastModifiedDate();

    /**
     * Sets the object who deleted entity.
     *
     * @param deletedBy the object to set
     * @see Deletable
     */
    void setDeletedBy(E deletedBy);

    /**
     * Returns of the object who deleted entity.
     *
     * @return the object who deleted entity
     * @see Deletable
     */
    Optional<E> getDeletedBy();

    /**
     * Sets the deleting date of the entity.
     *
     * @param deletedDate the deleting date
     * @see Deletable
     */
    void setDeletedDate(TemporalAccessor deletedDate);

    /**
     * Returns the deleting date of the entity.
     *
     * @return the deleting date of the entity
     * @see Deletable
     */
    TemporalAccessor getDeletedDate();
}
