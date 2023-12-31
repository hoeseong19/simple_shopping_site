package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_line_items")
public class CartLineItem extends BaseEntity {
    @EmbeddedId
    private CartLineItemId id;

    private CartLineItem() {
        super();
    }

    public CartLineItem(CartLineItemId id) {
        this.id = id;
    }

    public CartLineItemId id() {
        return id;
    }
}
