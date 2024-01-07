package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @EmbeddedId
    private ProductId id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "category_id"))
    private CategoryId categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Embedded
    @AttributeOverride(name = "amount", column = @Column(name = "price"))
    private Money price;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    @OrderBy("id")
    private List<Image> images = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    @OrderBy("id")
    private List<ProductOption> options = new ArrayList<>();

    private Product() {
        super();
    }

    public Product(ProductId id, CategoryId categoryId, String name, Money price, List<Image> images) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.images = images;
    }

    public ProductId id() {
        return id;
    }

    public CategoryId categoryId() {
        return categoryId;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public List<Image> images() {
        return images;
    }

    public Image image(int idx) {
        return images.get(idx);
    }

    public Money price() {
        return price;
    }

    public List<ProductOption> options() {
        return options;
    }

    public ProductOption optionById(ProductOptionId id) {
        return options.stream()
                .filter(option -> option.id().toString().equals(id.toString()))
                .findFirst()
                .orElseThrow();
    }
}
