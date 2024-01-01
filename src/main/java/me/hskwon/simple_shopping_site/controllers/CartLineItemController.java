package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.cart.AddProductToCartService;
import me.hskwon.simple_shopping_site.dtos.AddProductToCartDto;
import me.hskwon.simple_shopping_site.models.*;
import me.hskwon.simple_shopping_site.security.AuthUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart/line-items")
public class CartLineItemController {
    private final AddProductToCartService addProductToCartService;

    public CartLineItemController(AddProductToCartService addProductToCartService) {
        this.addProductToCartService = addProductToCartService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCartLineItem(
            Authentication authentication,
            @RequestBody AddProductToCartDto dto
    ) {
        AuthUser authUser = (AuthUser) authentication.getPrincipal();

        Set<CartLineItemOption> options = dto.options().stream()
                .map(option ->
                        new CartLineItemOption(
                                new ProductOptionId(option.id()),
                                new ProductOptionItemId(option.itemId())
                        )
                )
                .collect(Collectors.toSet());

        addProductToCartService.addProduct(
                new ProductId(dto.productId()),
                new UserId(authUser.id()),
                options
        );
    }
}
