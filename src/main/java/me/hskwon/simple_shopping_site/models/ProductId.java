package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductId {
    @Column(name = "id")
    String value;

    @Override
    public String toString() {
        return value;
    }
}
