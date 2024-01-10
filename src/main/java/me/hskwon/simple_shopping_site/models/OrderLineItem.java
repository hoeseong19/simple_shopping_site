package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_line_items")
public class OrderLineItem extends BaseEntity<OrderLineItemId> {
    private OrderLineItem() {
    }

    public OrderLineItem(OrderLineItemId id) {
        super(id);
    }
}
