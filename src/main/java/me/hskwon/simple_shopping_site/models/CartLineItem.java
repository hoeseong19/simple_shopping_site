package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cart_line_items")
public class CartLineItem extends BaseEntity {
    @EmbeddedId
    private CartLineItemId id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "product_id"))
    private ProductId productId;

    @ElementCollection
    @CollectionTable(
            name = "cart_line_item_options",
            joinColumns = @JoinColumn(name = "cart_line_item_id")
    )
    private Set<CartLineItemOption> options = new HashSet<>();

    @Column(name = "quantity", nullable = false)
    private int quantity = 0;

    private CartLineItem() {
        super();
    }

    public CartLineItem(CartLineItemId id, ProductId productId, Set<CartLineItemOption> options, int quantity) {
        this.id = id;
        this.productId = productId;
        this.options = options;
        this.quantity = quantity;
    }

    public CartLineItemId id() {
        return id;
    }

    public ProductId productId() {
        return productId;
    }

    public List<ProductOptionId> optionIds() {
        return options.stream().map(CartLineItemOption::optionId).toList();
    }

    public ProductOptionItemId optionItemId(ProductOptionId optionId) {
        return options.stream()
                .filter(cartOption -> cartOption.optionId().toString().equals(optionId.toString()))
                .map(CartLineItemOption::optionItemId)
                .findFirst()
                .orElseThrow();
    }

    public int quantity() {
        return quantity;
    }
}
