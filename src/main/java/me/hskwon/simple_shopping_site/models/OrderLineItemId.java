package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderLineItemId extends EntityId {
    private OrderLineItemId() {
    }

    public OrderLineItemId(String value) {
        super(value);
    }
}
