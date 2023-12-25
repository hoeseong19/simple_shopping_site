package me.hskwon.simple_shopping_site.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SessionController.class)
class SessionControllerTest extends ControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("POST /session")
    void testLogin() throws Exception {
        RequestBuilder requestBuilder = post("/session");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated());
    }
}