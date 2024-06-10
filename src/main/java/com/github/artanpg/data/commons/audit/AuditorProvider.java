package com.github.artanpg.data.commons.audit;

/**
 * Interface for components that are aware of the application's current auditor.
 *
 * @param <T> the type of the auditing instance
 * @author Mohammad Yazdina
 */
@FunctionalInterface
public interface AuditorProvider<T> {

    /**
     * Returns the current auditor of the application.
     *
     * @return the current auditor
     */
    T getCurrentAuditor();
}
