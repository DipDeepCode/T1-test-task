package ru.ddc.t1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.ddc.t1.service.NumberOfOccurrencesCalculator;

import java.util.LinkedHashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OccurrencesController.class)
class OccurrencesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private NumberOfOccurrencesCalculator calculator;

    @Test
    public void when_getWithParam_then_statusIsOk() throws Exception {
        mockMvc.perform(get("/occurrence/calculate").param("str", ""))
                .andExpect(status().isOk());
    }

    @Test
    public void when_getWithoutParam_then_statusIsBadRequest() throws Exception {
        mockMvc.perform(get("/occurrence/calculate"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void checkContentFormat() throws Exception {
        LinkedHashMap<Character, Integer> calculatorResponse = new LinkedHashMap<>() {{
            put('a', 3);
            put('c', 2);
            put('b', 1);
        }};
        when(calculator.getNumberOfOccurrence(any())).thenReturn(calculatorResponse);

        String expected = "{\"a\":3,\"c\":2,\"b\":1}";

        this.mockMvc.perform(get("/occurrence/calculate").param("str", ""))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(expected));
    }
}
