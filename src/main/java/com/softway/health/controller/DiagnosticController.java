package com.softway.health.controller;

import com.softway.health.service.interfaces.DiagnosticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiagnosticController {

    private static final Logger logger = LoggerFactory.getLogger(DiagnosticController.class);

    @Autowired
    private DiagnosticService diagnosticService;

    @GetMapping("/diagnostic")
    public String getDiagnostic(@RequestParam int code) {
        logger.info("Received code: {}", code);
        return diagnosticService.determinateDiagnostic(code);
    }
}
