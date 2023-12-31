package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class CartLineItemId extends EntityId {
    private CartLineItemId() {
        super();
    }

    public CartLineItemId(String value) {
        super(value);
    }
}
