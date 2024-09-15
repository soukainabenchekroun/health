package com.softway.health.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class DiagnosticServiceImplTest {

    private DiagnosticServiceImpl diagnosticService;

    @BeforeEach
    void setUp() {
        diagnosticService = new DiagnosticServiceImpl();
    }

    @Test
    void shouldReturnBothWhenMultipleOfThreeAndFive() {
        assertEquals(DiagnosticServiceImpl.DIAGNOSTIC_BOTH, diagnosticService.determinateDiagnostic(15));
    }

    @Test
    void shouldReturnCardiologyWhenMultipleOfThreeOnly() {
        assertEquals(DiagnosticServiceImpl.DIAGNOSTIC_CARDIOLOGY,
                diagnosticService.determinateDiagnostic(9));
    }

    @Test
    void shouldReturnTraumatologyWhenMultipleOfFiveOnly() {
        assertEquals(DiagnosticServiceImpl.DIAGNOSTIC_TRAUMATOLOGY,
                diagnosticService.determinateDiagnostic(10));
    }

    @Test
    void shouldReturnNoneWhenNotMultipleOfThreeOrFive() {
        assertEquals(DiagnosticServiceImpl.DIAGNOSTIC_NONE,
                diagnosticService.determinateDiagnostic(1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNegativeCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            diagnosticService.determinateDiagnostic(-1);
        });
        assertEquals("Code must be positive.", exception.getMessage());
    }
}
