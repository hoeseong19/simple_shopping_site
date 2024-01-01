package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.util.Objects;

@Embeddable
public class CartLineItemOption {
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "product_option_id"))
    private ProductOptionId productOptionId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "product_option_item_id"))
    private ProductOptionItemId productOptionItemId;

    private CartLineItemOption() {
    }

    public CartLineItemOption(
            ProductOptionId productOptionId,
            ProductOptionItemId productOptionItemId
    ) {
        this.productOptionId = productOptionId;
        this.productOptionItemId = productOptionItemId;
    }

    public ProductOptionId optionId() {
        return productOptionId;
    }

    public ProductOptionItemId optionItemId() {
        return productOptionItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartLineItemOption that = (CartLineItemOption) o;
        return Objects.equals(productOptionId, that.productOptionId) && Objects.equals(productOptionItemId, that.productOptionItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productOptionId, productOptionItemId);
    }
}
