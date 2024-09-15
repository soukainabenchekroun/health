package com.softway.health.controller;

import com.softway.health.service.interfaces.DiagnosticService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DiagnosticController.class)
@ExtendWith(SpringExtension.class)
class DiagnosticControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DiagnosticService diagnosticService;

    @Test
    void whenCode33ShouldReturnCardiology() throws Exception {
        int code = 33;
        when(diagnosticService.determinateDiagnostic(code)).thenReturn("Cardiologie");

        mockMvc.perform(get("/diagnostic")
                        .param("code", String.valueOf(code))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Cardiologie"));
    }

    @Test
    void whenCode55ShouldReturnTraumatology() throws Exception {
        int code = 55;
        when(diagnosticService.determinateDiagnostic(code)).thenReturn("Traumatologie");

        mockMvc.perform(get("/diagnostic")
                        .param("code", String.valueOf(code))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Traumatologie"));
    }

    @Test
    void whenCode15ShouldReturnCardiologyAndTraumatology() throws Exception {
        int code = 15;
        when(diagnosticService.determinateDiagnostic(code)).thenReturn("Cardiologie, Traumatologie");

        mockMvc.perform(get("/diagnostic")
                        .param("code", String.valueOf(code))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Cardiologie, Traumatologie"));
    }
}
