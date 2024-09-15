package com.softway.health.exception;

import com.softway.health.controller.DiagnosticController;
import com.softway.health.service.interfaces.DiagnosticService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DiagnosticController.class)
public class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DiagnosticService diagnosticService;

    @Test
    public void whenExceptionThrown_thenBadRequestResponse() throws Exception {
        // Simulate the service throwing a generic exception
        doThrow(new RuntimeException("Unexpected error")).when(diagnosticService).determinateDiagnostic(0);

        mockMvc.perform(get("/diagnostic")
                        .param("code", "-1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("getDiagnostic.code: Code must be positive"));
    }
}
