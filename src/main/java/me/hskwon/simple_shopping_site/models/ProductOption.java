package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_options")
public class ProductOption extends BaseEntity {
    @EmbeddedId
    private ProductOptionId id;

    @Column(name = "name")
    private String name;

    private ProductOption() {
        super();
    }

    public ProductOption(ProductOptionId id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductOptionId id() {
        return id;
    }

    public String name() {
        return name;
    }
}
