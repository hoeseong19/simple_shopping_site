package me.hskwon.simple_shopping_site.application.orders;

import jakarta.transaction.Transactional;
import me.hskwon.simple_shopping_site.models.Order;
import me.hskwon.simple_shopping_site.models.OrderId;
import me.hskwon.simple_shopping_site.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateOrderService {
    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder() {
        Order newOrder = new Order(OrderId.generate());

        orderRepository.save(newOrder);
    }
}
