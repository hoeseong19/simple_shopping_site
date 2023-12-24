package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_option_items")
public class ProductOptionItem extends BaseEntity {
    @EmbeddedId
    ProductOptionItemId id;

    @Column(name = "name")
    String name;

    private ProductOptionItem() {
        super();
    }

    public ProductOptionItem(ProductOptionItemId id, String name) {
        this.id = id;
        this.name = name;
    }
}
