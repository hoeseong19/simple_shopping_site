package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_options")
public class ProductOption extends BaseEntity {
    @EmbeddedId
    private ProductOptionId id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_option_id")
    @OrderBy("id")
    private List<ProductOptionItem> items = new ArrayList<>();

    private ProductOption() {
        super();
    }

    public ProductOption(ProductOptionId id, String name, List<ProductOptionItem> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public ProductOptionId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public int itemSize() {
        return items.size();
    }

    public ProductOptionItem item(int index) {
        return items.get(index);
    }

    public ProductOptionItem itemById(ProductOptionItemId id) {
        return items.stream()
                .filter(item -> item.id().toString().equals(id.toString()))
                .findFirst()
                .orElseThrow();
    }
}
