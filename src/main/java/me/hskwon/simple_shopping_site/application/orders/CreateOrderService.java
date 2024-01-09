package me.hskwon.simple_shopping_site.application.orders;

import jakarta.transaction.Transactional;
import me.hskwon.simple_shopping_site.enums.OrderStatus;
import me.hskwon.simple_shopping_site.models.*;
import me.hskwon.simple_shopping_site.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateOrderService {
    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(
            UserId userId,
            Receiver receiver,
            Payment payment
    ) {
        Order newOrder = new Order(
                OrderId.generate(),
                userId,
                receiver,
                payment,
                OrderStatus.PAID
        );

        orderRepository.save(newOrder);
    }
}
