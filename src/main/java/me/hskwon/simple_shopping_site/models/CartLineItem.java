package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_line_items")
public class CartLineItem extends BaseEntity {
    @EmbeddedId
    private CartLineItemId id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "product_id"))
    private ProductId productId;

    private CartLineItem() {
        super();
    }

    public CartLineItem(CartLineItemId id) {
        this.id = id;
    }

    public CartLineItemId id() {
        return id;
    }

    public ProductId productId() {
        return productId;
    }
}
