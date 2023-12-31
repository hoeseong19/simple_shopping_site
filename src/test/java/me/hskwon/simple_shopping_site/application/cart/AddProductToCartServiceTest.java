package me.hskwon.simple_shopping_site.application.cart;

import me.hskwon.simple_shopping_site.repositories.CartRepository;
import me.hskwon.simple_shopping_site.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

class AddProductToCartServiceTest {
    private AddProductToCartService addProductToCartService;

    private CartRepository cartRepository;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        cartRepository = mock(CartRepository.class);
        productRepository = mock(ProductRepository.class);
        addProductToCartService = new AddProductToCartService(
                cartRepository,
                productRepository
        );
    }
}