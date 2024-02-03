package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_line_items")
public class OrderLineItem extends BaseEntity<OrderLineItemId> {
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_line_item_id")
    @OrderBy("id")
    private List<OrderOption> options = new ArrayList<>();

    private OrderLineItem() {
    }

    public OrderLineItem(OrderLineItemId id, List<OrderOption> options) {
        super(id);
        this.options = options;
    }

    public int optionSize() {
        return options.size();
    }

    public OrderOption option(int index) {
        return options.get(index);
    }
}
