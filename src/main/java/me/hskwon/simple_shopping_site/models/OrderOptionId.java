package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderOptionId extends EntityId {
    private OrderOptionId() {
    }

    public OrderOptionId(String value) {
        super(value);
    }
}
