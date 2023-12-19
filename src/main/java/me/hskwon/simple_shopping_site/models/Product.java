package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @EmbeddedId
    private ProductId id;

    @Column(name = "name")
    private String name;

    @Embedded
    @AttributeOverride(name = "amount", column = @Column(name = "price"))
    private Money price;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    @OrderBy("id")
    private List<Image> images = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_options")
    @OrderBy("id")
    private List<ProductOption> options = new ArrayList<>();

    private Product() {
        super();
    }

    public Product(ProductId id, String name, Money price, List<Image> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.images = images;
    }

    public ProductId id() {
        return id;
    }

    public String name() {
        return name;
    }
}
