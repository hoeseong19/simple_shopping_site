package me.hskwon.simple_shopping_site.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartController.class)
class CartControllerTest extends ControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("GET /cart")
    void getCart() throws Exception {
        RequestBuilder requestBuilder = get("/cart")
                .header("Authorization", "Bearer %s".formatted(accessToken));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }
}