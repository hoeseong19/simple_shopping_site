package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.cart.GetCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final GetCartService getCartService;

    public CartController(GetCartService getCartService) {
        this.getCartService = getCartService;
    }

    @GetMapping
    public String getCart() {
        return "";
    }
}
