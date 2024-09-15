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
        logger.info(LOG_RECEIVED_CODE, code);

        boolean isMultipleOfThree = code % 3 == 0;
        boolean isMultipleOfFive = code % 5 == 0;

        if (isMultipleOfThree && isMultipleOfFive) {
            logger.info(LOG_DIAGNOSTIC, DIAGNOSTIC_BOTH);
            return DIAGNOSTIC_BOTH;
        } else if (isMultipleOfThree) {
            logger.info(LOG_DIAGNOSTIC, DIAGNOSTIC_CARDIOLOGY);
            return DIAGNOSTIC_CARDIOLOGY;
        } else if (isMultipleOfFive) {
            logger.info(LOG_DIAGNOSTIC, DIAGNOSTIC_TRAUMATOLOGY);
            return DIAGNOSTIC_TRAUMATOLOGY;
        } else {
            logger.info(LOG_NO_PATHOLOGY);
            return DIAGNOSTIC_NONE;
        }
    }
}
