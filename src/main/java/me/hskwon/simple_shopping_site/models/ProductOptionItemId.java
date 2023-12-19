package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductOptionItemId extends EntityId {
    private ProductOptionItemId() {
        super();
    }

    public ProductOptionItemId(String value) {
        super(value);
    }
}
