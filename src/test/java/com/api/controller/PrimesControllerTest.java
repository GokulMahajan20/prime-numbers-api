package com.api.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PrimesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void apiIntegrationPositiveTestPrimes() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/primes/10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("initial", Matchers.is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("primes", Matchers.hasItems(2, 3, 5, 7)));
    }

    @Test
    public void apiIntegrationPositiveParamTestPrimes() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/primes/10?executionType='parallel'"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("initial", Matchers.is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("primes", Matchers.hasItems(2, 3, 5, 7)));
    }

    @Test
    public void apiIntegrationNegativeTestPrimes() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/primes/10"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
