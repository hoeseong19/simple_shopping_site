package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.*;
import me.hskwon.simple_shopping_site.enums.OrderStatus;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity<OrderId> {
    public Order() {
    }

    @Column
    @AttributeOverride(name = "value", column = @Column(name = "user_id"))
    private UserId userId;

    @Embedded
    private Receiver receiver;

    @Embedded
    private Payment payment;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order(OrderId id, UserId userId, Receiver receiver, Payment payment) {
        super(id);
        this.userId = userId;
        this.receiver = receiver;
        this.payment = payment;
    }
}
