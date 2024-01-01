package me.hskwon.simple_shopping_site.application.cart;

import me.hskwon.simple_shopping_site.models.Cart;
import me.hskwon.simple_shopping_site.models.UserId;
import me.hskwon.simple_shopping_site.repositories.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetCartServiceTest {
    private GetCartService getCartService;
    private CartRepository cartRepository;

    @BeforeEach
    void setUp() {
        cartRepository = mock(CartRepository.class);

        getCartService = new GetCartService(cartRepository);
    }

    @Test
    void testGetCart() {
        UserId userId = new UserId("userId");

        Cart cart = getCartService.getCart(userId);

        assertThat(cart).isNotNull();

        verify(cartRepository).findByUserId(userId);
    }
}