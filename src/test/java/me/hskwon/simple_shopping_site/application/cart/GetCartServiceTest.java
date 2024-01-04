package me.hskwon.simple_shopping_site.application.cart;

import me.hskwon.simple_shopping_site.models.Cart;
import me.hskwon.simple_shopping_site.models.UserId;
import me.hskwon.simple_shopping_site.repositories.CartRepository;
import me.hskwon.simple_shopping_site.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetCartServiceTest {
    private GetCartService getCartService;
    private CartRepository cartRepository;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        cartRepository = mock(CartRepository.class);
        productRepository = mock(ProductRepository.class);

        getCartService = new GetCartService(cartRepository, productRepository);
    }

    @Test
    void testGetCart() {
        UserId userId = new UserId("userId");

        Cart cart = getCartService.getCart(userId);

        assertThat(cart).isNotNull();

        verify(cartRepository).findByUserId(userId);
    }
}