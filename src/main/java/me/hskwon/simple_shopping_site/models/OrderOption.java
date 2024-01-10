package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_options")
public class OrderOption extends BaseEntity<OrderOptionId> {
    private OrderOption() {
    }

    public OrderOption(OrderOptionId id) {
        super(id);
    }
}
