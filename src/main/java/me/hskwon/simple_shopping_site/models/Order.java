package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity<OrderId> {
    public Order() {
    }

    public Order(OrderId id) {
        super(id);
    }
}
