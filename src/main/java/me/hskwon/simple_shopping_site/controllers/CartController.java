package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.cart.GetCartService;
import me.hskwon.simple_shopping_site.dtos.CartDto;
import me.hskwon.simple_shopping_site.models.UserId;
import me.hskwon.simple_shopping_site.security.AuthUser;
import org.springframework.security.core.Authentication;
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
    public CartDto getCart(
            Authentication authentication
    ) {
        AuthUser authUser = (AuthUser) authentication.getPrincipal();

        return getCartService.getCartDto(new UserId(authUser.id()));
    }
}
