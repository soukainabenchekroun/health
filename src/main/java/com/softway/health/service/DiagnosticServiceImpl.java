package com.softway.health.service;

import com.softway.health.service.interfaces.DiagnosticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.softway.health.util.DiagnosticConstants.*;

/**
 * Implementation of the diagnostic service
 */
@Service
public class DiagnosticServiceImpl implements DiagnosticService {

    private static final Logger logger = LoggerFactory.getLogger(DiagnosticServiceImpl.class);

    /**
     * Implementation of the diagnostic service
     *
     * @param code The code to determine the diagnostic
     * @return The diagnostic determined
     */
    @Override
    public String determinateDiagnostic(int code) {
        logger.info("Determining diagnostic for code: {}", code);

        boolean isMultipleOfThree = isMultipleOf(code, 3);
        boolean isMultipleOfFive = isMultipleOf(code, 5);

        if (code <= 0) {
            logger.error("Invalid code: {}", code);
            throw new IllegalArgumentException("Code must be positive.");
        }

        if (isMultipleOfThree && isMultipleOfFive) {
            logger.info("Diagnostic: {}", DIAGNOSTIC_BOTH);
            return DIAGNOSTIC_BOTH;
        } else if (isMultipleOfThree) {
            logger.info("Diagnostic: {}", DIAGNOSTIC_CARDIOLOGY);
            return DIAGNOSTIC_CARDIOLOGY;
        } else if (isMultipleOfFive) {
            logger.info("Diagnostic: {}", DIAGNOSTIC_TRAUMATOLOGY);
            return DIAGNOSTIC_TRAUMATOLOGY;
        } else {
            logger.info("No pathology detected");
            return DIAGNOSTIC_NONE;
        }
    }

    /**
     * Determines if a code is a multiple of a divisor
     *
     * @param code    The code to determine if it is a multiple
     * @param divisor The divisor to determine if the code is a multiple
     * @return True if the code is a multiple of the divisor, false otherwise
     */
    private boolean isMultipleOf(int code, int divisor) {
        return code % divisor == 0;
    }
}
