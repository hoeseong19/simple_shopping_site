package me.hskwon.simple_shopping_site.application.cart;

import me.hskwon.simple_shopping_site.repositories.CartRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

class GetCartServiceTest {
    private GetCartService getCartService;
    private CartRepository cartRepository;

    @BeforeEach
    void setUp() {
        cartRepository = mock(CartRepository.class);

        getCartService = new GetCartService(cartRepository);
    }
}