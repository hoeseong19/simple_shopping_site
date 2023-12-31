package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.cart.AddProductToCartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart/line-items")
public class CartLineItemController {
    private final AddProductToCartService addProductToCartService;

    public CartLineItemController(AddProductToCartService addProductToCartService) {
        this.addProductToCartService = addProductToCartService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCartLineItem() {
    }
}
