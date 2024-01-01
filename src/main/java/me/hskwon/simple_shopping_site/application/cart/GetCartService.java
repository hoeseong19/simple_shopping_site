package me.hskwon.simple_shopping_site.application.cart;

import me.hskwon.simple_shopping_site.repositories.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class GetCartService {
    private final CartRepository cartRepository;

    public GetCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
}
