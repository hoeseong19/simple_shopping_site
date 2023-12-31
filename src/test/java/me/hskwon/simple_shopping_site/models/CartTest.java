package me.hskwon.simple_shopping_site.models;

import org.junit.jupiter.api.BeforeEach;

class CartTest {
    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart(new UserId("userId"));
    }
}