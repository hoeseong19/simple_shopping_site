package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart extends BaseEntity<CartId> {
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "user_id"))
    private UserId userId;

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

    public Cart(CartId id, UserId userId) {
        this.id = id;
        this.userId = userId;
    }

    public CartId id() {
        return id;
    }

    public CartLineItem item(int index) {
        return items.get(index);
    }

    public int itemSize() {
        return items.size();
    }

    public void addProduct(
            ProductId productId,
            Set<CartLineItemOption> options,
            int quantity
    ) {
        CartLineItemId cartLineItemId = CartLineItemId.generate();
        CartLineItem item = new CartLineItem(
                cartLineItemId,
                productId,
                options,
                quantity
        );

        items.add(item);
    }
}
