package com.softway.health.service.interfaces;

/**
 * Service to determine the diagnostic based on the code received
 */
public interface DiagnosticService {

    /**
     * Determines the diagnostic based on the code received
     *
     * @param code The code to determine the diagnostic
     * @return The diagnostic determined
     */
    String determinateDiagnostic(int code);
}
