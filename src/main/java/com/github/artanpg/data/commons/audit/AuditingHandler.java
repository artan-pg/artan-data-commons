package com.github.artanpg.data.commons.audit;

import com.github.artanpg.data.commons.domain.Auditable;
import com.github.artanpg.data.commons.domain.Deletable;

import java.util.Objects;

/**
 * Auditing handler to mark entity objects created, modified and deleted.
 *
 * @author Mohammad Yazdian
 */
public class AuditingHandler {

    private final AuditorAware<Object> auditorAware;
    private final TemporalAccessorProvider temporalAccessorProvider;

    public AuditingHandler(AuditorAware<Object> auditorAware,
                           TemporalAccessorProvider temporalAccessorProvider) {
        this.auditorAware = auditorAware;
        this.temporalAccessorProvider = temporalAccessorProvider;
    }

    /**
     * Marks the given entity object as created
     *
     * @param target Entity object to mark
     */
    @SuppressWarnings("unchecked")
    public void markCreated(Object target) {
        checkNullTargetObject(target);
        if (!(target instanceof Auditable<?, ?>)) {
            throw new IllegalArgumentException("The target must be of Auditable type.");
        }
        Auditable<Object, ?> auditable = (Auditable<Object, ?>) target;
        auditable.setCreatedBy(auditorAware.getCurrentAuditor());
        auditable.setCreatedDate(temporalAccessorProvider.getTemporalAccessor());
    }

    /**
     * Marks the given entity object as updated
     *
     * @param target Entity object to mark
     */
    @SuppressWarnings("unchecked")
    public void markUpdated(Object target) {
        checkNullTargetObject(target);
        if (!(target instanceof Auditable<?, ?>)) {
            throw new IllegalArgumentException("The target must be of Auditable type.");
        }
        Auditable<Object, ?> auditable = (Auditable<Object, ?>) target;
        auditable.setLastModifiedBy(auditorAware.getCurrentAuditor());
        auditable.setLastModifiedDate(temporalAccessorProvider.getTemporalAccessor());
    }

    /**
     * Marks the given entity object as updated
     *
     * @param target Entity object to mark
     */
    @SuppressWarnings("unchecked")
    public void markDeleted(Object target) {
        checkNullTargetObject(target);
        if (!(target instanceof Auditable<?, ?> && target instanceof Deletable<?>)) {
            throw new IllegalArgumentException("The target must be of Auditable and Deletable type.");
        }
        Auditable<Object, ?> auditable = (Auditable<Object, ?>) target;
        auditable.setDeletedBy(auditorAware.getCurrentAuditor());
        auditable.setDeletedDate(temporalAccessorProvider.getTemporalAccessor());
    }

    private void checkNullTargetObject(Object target) {
        if (Objects.isNull(target)) {
            throw new IllegalArgumentException("The target can not be null.");
        }
    }
}
