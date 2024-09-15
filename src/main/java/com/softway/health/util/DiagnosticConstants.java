package com.softway.health.util;

/**
 * Constants for diagnostics
 */
public class DiagnosticConstants {

    // Diagnostics
    public static final String DIAGNOSTIC_CARDIOLOGY = "Cardiologie";
    public static final String DIAGNOSTIC_TRAUMATOLOGY = "Traumatologie";
    public static final String DIAGNOSTIC_BOTH = DIAGNOSTIC_CARDIOLOGY + ", " + DIAGNOSTIC_TRAUMATOLOGY;
    public static final String DIAGNOSTIC_NONE = "No pathology detected";

    // Log messages
    public static final String LOG_RECEIVED_CODE = "Code received: {}";
    public static final String LOG_DIAGNOSTIC = "Diagnostic: {}";
    public static final String LOG_NO_PATHOLOGY = "No pathology detected";
}
