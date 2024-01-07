package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderId extends EntityId {
    public OrderId() {
    }

    public OrderId(String value) {
        super(value);
    }

    public static OrderId generate() {
        return new OrderId(tsid());
    }
}
