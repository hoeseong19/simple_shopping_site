package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductId extends EntityId {
    private ProductId() {
        super();
    }

    public ProductId(String value) {
        super(value);
    }
}
