package me.hskwon.simple_shopping_site.application.orders;

import me.hskwon.simple_shopping_site.Fixtures;
import me.hskwon.simple_shopping_site.models.Payment;
import me.hskwon.simple_shopping_site.models.Receiver;
import me.hskwon.simple_shopping_site.models.UserId;
import me.hskwon.simple_shopping_site.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
        UserId userId = new UserId("userId");

        Receiver receiver = Fixtures.receiver();
        Payment payment = Fixtures.payment();

        createOrderService.createOrder(userId, receiver, payment);

        verify(orderRepository).save(any());
    }
}