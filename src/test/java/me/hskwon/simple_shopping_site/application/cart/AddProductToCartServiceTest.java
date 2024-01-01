package me.hskwon.simple_shopping_site.application.cart;

import me.hskwon.simple_shopping_site.Fixtures;
import me.hskwon.simple_shopping_site.models.CartLineItemOption;
import me.hskwon.simple_shopping_site.models.Product;
import me.hskwon.simple_shopping_site.models.UserId;
import me.hskwon.simple_shopping_site.repositories.CartRepository;
import me.hskwon.simple_shopping_site.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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

    @Test
    @DisplayName("addProduct - with valid productId")
    void testAddProductWithValidProductId() {
        Product product = Fixtures.product();
        UserId userId = new UserId("userId");
        Set<CartLineItemOption> options = Fixtures.options();

        given(productRepository.findById(product.id()))
                .willReturn(Optional.of(product));

        addProductToCartService.addProduct(product.id(), userId, options);

        verify(cartRepository).save(any());
    }

    @Test
    @DisplayName("addProduct - with invalid productId")
    void testAddProductWithInvalidProductId() {
        Product product = Fixtures.product();
        UserId userId = new UserId("userId");
        Set<CartLineItemOption> options = Fixtures.options();

        given(productRepository.findById(product.id()))
                .willReturn(Optional.empty());

        assertThatThrownBy(() -> addProductToCartService.addProduct(product.id(), userId, options))
                .isInstanceOf(NoSuchElementException.class);

        verify(cartRepository, never()).save(any());
    }
}