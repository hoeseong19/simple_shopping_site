package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class CartId extends EntityId {
    private CartId() {
        super();
    }

    public CartId(String value) {
        super(value);
    }
}
