package me.hskwon.simple_shopping_site.models;

import me.hskwon.simple_shopping_site.Fixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CartTest {
    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart(CartId.generate(), new UserId("userId"));
    }

    @Test
    @DisplayName("addProduct")
    void testAddProduct() {
        Product product = Fixtures.product();
        Set<CartLineItemOption> options = Fixtures.options();
        int quantity = 2;

        cart.addProduct(product.id(), options, quantity);

        assertThat(cart.itemSize()).isEqualTo(1);
    }
}