package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.orders.CreateOrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest extends ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateOrderService createOrderService;

    @Test
    @DisplayName("POST /orders")
    void testCreateOrder() throws Exception {
        RequestBuilder requestBuilder = post("/orders")
                .header("Authorization", "Bearer %s".formatted(accessToken));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated());
    }
}