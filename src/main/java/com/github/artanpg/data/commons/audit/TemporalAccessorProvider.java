package com.github.artanpg.data.commons.audit;

import java.time.temporal.TemporalAccessor;

/**
 * Simple interface to calculate the {@link TemporalAccessor} instance to be
 * used when auditing.
 *
 * @author Mohammad Yazdian
 */
public interface TemporalAccessorProvider {

    /**
     * Returns an instance of {@code TemporalAccessor} for use in auditing
     *
     * @return An instance of {@code TemporalAccessor} for use in auditing
     */
    TemporalAccessor getTemporalAccessor();
}
