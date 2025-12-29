package com.example.demo;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Epic("Resource Management")
@WebMvcTest(ResourceController.class)
public class ResourceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Feature("Resource Status Endpoint")
    @Story("Get Resource Status")
    @Description("Verifies that the /resource-status endpoint returns a valid JSON response with Pong message")
    public void testGetResourceStatusReturnsPong() throws Exception {
        mockMvc.perform(get("/resource-status"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"Pong\"}"));
    }

    @Test
    @Feature("Resource Status Endpoint")
    @Story("Get Resource Status")
    @Description("Verifies that the /resource-status endpoint returns the correct content type as application/json")
    public void testGetResourceStatusContentType() throws Exception {
        mockMvc.perform(get("/resource-status"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
