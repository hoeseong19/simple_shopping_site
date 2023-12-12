package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Column;

public class CategoryId {
    @Column(name = "id")
    String value;

    private CategoryId() {
    }

    public CategoryId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
