package com.softway.health.controller;

import com.softway.health.model.Response;
import com.softway.health.service.interfaces.DiagnosticService;
import jakarta.validation.constraints.Positive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to determine the diagnostic based on the code received
 */
@RestController
@Validated
public class DiagnosticController {

    private static final Logger logger = LoggerFactory.getLogger(DiagnosticController.class);

    @Autowired
    private DiagnosticService diagnosticService;

    /**
     * Get the diagnostic based on the code received
     *
     * @param code The code to determine the diagnostic
     * @return The ResponseEntity with the diagnostic determined
     */
    @GetMapping("/diagnostic")
    public ResponseEntity<Response> getDiagnostic(@RequestParam @Positive(message = "Code must be positive") int code) {
        String result = diagnosticService.determinateDiagnostic(code);
        return ResponseEntity.ok(new Response(HttpStatus.OK.value(), result));
    }

}
