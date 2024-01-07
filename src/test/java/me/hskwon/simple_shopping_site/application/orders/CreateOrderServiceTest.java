package me.hskwon.simple_shopping_site.application.orders;

import me.hskwon.simple_shopping_site.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class CreateOrderServiceTest {
    private CreateOrderService createOrderService;
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        createOrderService = new CreateOrderService(orderRepository);
    }

    @Test
    void testCreateOrder() {
        createOrderService.createOrder();
    }
}