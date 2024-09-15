package com.softway.health.controller;

import com.softway.health.service.interfaces.DiagnosticService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DiagnosticController.class)
public class DiagnosticControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DiagnosticService diagnosticService;

    @Test
    public void testGetDiagnostic() throws Exception {
        given(diagnosticService.determinateDiagnostic(33)).willReturn("Cardiologie");
        given(diagnosticService.determinateDiagnostic(55)).willReturn("Traumatologie");
        given(diagnosticService.determinateDiagnostic(15)).willReturn("Cardiologie, Traumatologie");

        mockMvc.perform(get("/diagnostic")
                        .param("code", "33")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.message").value("Cardiologie"));

        mockMvc.perform(get("/diagnostic")
                        .param("code", "55")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.message").value("Traumatologie"));

        mockMvc.perform(get("/diagnostic")
                        .param("code", "15")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.message").value("Cardiologie, Traumatologie"));
    }

    @Test
    public void testGetDiagnosticWithError() throws Exception {
        mockMvc.perform(get("/diagnostic")
                        .param("code", "-1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").isNotEmpty());
    }
}
