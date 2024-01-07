package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.*;

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

    public Order(OrderId id, UserId userId, Receiver receiver, Payment payment) {
        super(id);
        this.userId = userId;
        this.receiver = receiver;
        this.payment = payment;
    }
}
