package me.hskwon.simple_shopping_site.application.cart;

import jakarta.transaction.Transactional;
import me.hskwon.simple_shopping_site.repositories.CartRepository;
import me.hskwon.simple_shopping_site.repositories.ProductRepository;
import org.springframework.stereotype.Service;

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
}
