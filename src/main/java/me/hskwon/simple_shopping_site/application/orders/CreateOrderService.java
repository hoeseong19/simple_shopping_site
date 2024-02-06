package me.hskwon.simple_shopping_site.application.orders;

import jakarta.transaction.Transactional;
import me.hskwon.simple_shopping_site.enums.OrderStatus;
import me.hskwon.simple_shopping_site.models.*;
import me.hskwon.simple_shopping_site.repositories.CartRepository;
import me.hskwon.simple_shopping_site.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CreateOrderService {
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;

    public CreateOrderService(CartRepository cartRepository, OrderRepository orderRepository) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
    }

    public void createOrder(
            UserId userId,
            Receiver receiver,
            Payment payment
    ) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(NoSuchElementException::new);

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
