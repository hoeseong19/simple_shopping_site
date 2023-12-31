package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart extends BaseEntity {
    @EmbeddedId
    private CartId id;

    private Cart() {
        super();
    }

    public Cart(CartId id) {
        this.id = id;
    }

    public CartId id() {
        return id;
    }
}
