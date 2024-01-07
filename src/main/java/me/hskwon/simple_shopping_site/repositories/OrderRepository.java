package me.hskwon.simple_shopping_site.repositories;

import me.hskwon.simple_shopping_site.models.Order;
import me.hskwon.simple_shopping_site.models.OrderId;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, OrderId> {
}
