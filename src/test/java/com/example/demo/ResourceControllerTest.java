package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ResourceController.class)
public class ResourceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetResourceStatusReturnsPong() throws Exception {
        mockMvc.perform(get("/resource-status"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"Pong\"}"));
    }

    @Test
    public void testGetResourceStatusContentType() throws Exception {
        mockMvc.perform(get("/resource-status"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
