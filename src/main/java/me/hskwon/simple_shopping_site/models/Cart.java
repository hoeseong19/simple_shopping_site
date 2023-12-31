package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart extends BaseEntity {
    @EmbeddedId
    private CartId id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    @OrderBy("id")
    private List<CartLineItem> items = new ArrayList<>();

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
