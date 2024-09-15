package com.softway.health.service;

import com.softway.health.service.interfaces.DiagnosticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * Implementation of the diagnostic service
 */
@Service
public class DiagnosticServiceImpl implements DiagnosticService {

    private static final Logger logger = LoggerFactory.getLogger(DiagnosticServiceImpl.class);

    // Constants
    public static final String DIAGNOSTIC_CARDIOLOGY = "Cardiologie";
    public static final String DIAGNOSTIC_TRAUMATOLOGY = "Traumatologie";
    public static final String DIAGNOSTIC_BOTH = DIAGNOSTIC_CARDIOLOGY + ", " + DIAGNOSTIC_TRAUMATOLOGY;
    public static final String DIAGNOSTIC_NONE = "No pathology detected";

    /**
     * Implementation of the diagnostic service
     *
     * @param code The code to determine the diagnostic
     * @return The diagnostic determined
     */
    @Override
    public String determinateDiagnostic(int code) {
        logger.info("Determining diagnostic for code: {}", code);

        // Check if the code is a multiple of 3 and 5
        boolean isMultipleOfThree = isMultipleOf(code, 3);
        boolean isMultipleOfFive = isMultipleOf(code, 5);

        // Check if the code is valid
        if (code <= 0) {
            logger.error("Invalid code: {}", code);
            throw new IllegalArgumentException("Code must be positive.");
        }

        // Determine the diagnostic
        return isMultipleOfThree && isMultipleOfFive ?
                DIAGNOSTIC_BOTH : isMultipleOfThree ?
                DIAGNOSTIC_CARDIOLOGY : isMultipleOfFive ?
                DIAGNOSTIC_TRAUMATOLOGY : DIAGNOSTIC_NONE;
    }

    /**
     * Determines if a code is a multiple of a divisor
     *
     * @param code    The code to determine if it is a multiple
     * @param divisor The divisor to determine if the code is a multiple
     * @return True if the code is a multiple of the divisor, false otherwise
     */
    private boolean isMultipleOf(int code, int divisor) {
        logger.info("Checking if {} is a multiple of {}", code, divisor);
        return code % divisor == 0;
    }
}
