package me.hskwon.simple_shopping_site.application.cart;

import me.hskwon.simple_shopping_site.models.Cart;
import me.hskwon.simple_shopping_site.models.CartId;
import me.hskwon.simple_shopping_site.models.UserId;
import me.hskwon.simple_shopping_site.repositories.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class GetCartService {
    private final CartRepository cartRepository;

    public GetCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCart(UserId userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElse(new Cart(CartId.generate(), userId));

        return cart;
    }
}
