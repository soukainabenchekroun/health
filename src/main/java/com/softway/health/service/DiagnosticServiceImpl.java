package com.softway.health.service;

import com.softway.health.service.interfaces.DiagnosticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticServiceImpl implements DiagnosticService {

    private static final Logger logger = LoggerFactory.getLogger(DiagnosticServiceImpl.class);

    @Override
    public String determinateDiagnostic(int code) {
        logger.info("Code received: {}", code);

        boolean isMultipleOfThree = code % 3 == 0;
        boolean isMultipleOfFive = code % 5 == 0;

        if (isMultipleOfThree && isMultipleOfFive) {
            logger.info("Diagnostic: Cardiologie, Traumatologie");
            return "Cardiologie, Traumatologie";
        } else if (isMultipleOfThree) {
            logger.info("Diagnostic: Cardiologie");
            return "Cardiologie";
        } else if (isMultipleOfFive) {
            logger.info("Diagnostic: Traumatologie");
            return "Traumatologie";
        } else {
            logger.info("No pathology detected");
            return "No pathology detected";
        }
    }
}
