package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity<OrderId> {
    public Order() {
    }

    @Column
    @AttributeOverride(name = "value", column = @Column(name = "user_id"))
    private UserId userId;

    public Order(OrderId id, UserId userId) {
        super(id);
        this.userId = userId;
    }
}
