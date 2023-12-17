package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityId {
    @Column(name = "id")
    String value;

    protected EntityId() {
    }

    protected EntityId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
