package me.hskwon.simple_shopping_site.application.cart;

import jakarta.transaction.Transactional;
import me.hskwon.simple_shopping_site.models.*;
import me.hskwon.simple_shopping_site.repositories.CartRepository;
import me.hskwon.simple_shopping_site.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Transactional
public class AddProductToCartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public AddProductToCartService(
            CartRepository cartRepository,
            ProductRepository productRepository
    ) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public void addProduct(
            ProductId productId,
            UserId userId,
            Set<CartLineItemOption> options
    ) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElse(new Cart(CartId.generate(), userId));

        productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException(""));

        cart.addProduct(productId, options);

        cartRepository.save(cart);
    }
}
