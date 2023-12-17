package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductOptionId extends EntityId {
    private ProductOptionId() {
        super();
    }

    public ProductOptionId(String value) {
        super(value);
    }
}
