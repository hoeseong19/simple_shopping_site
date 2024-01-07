package me.hskwon.simple_shopping_site.application.orders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateOrderServiceTest {
    private CreateOrderService createOrderService;

    @BeforeEach
    void setUp() {
        createOrderService = new CreateOrderService();
    }

    @Test
    void testCreateOrder() {
        createOrderService.createOrder();
    }
}