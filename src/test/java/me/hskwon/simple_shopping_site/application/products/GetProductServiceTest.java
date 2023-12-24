package me.hskwon.simple_shopping_site.application.products;

import me.hskwon.simple_shopping_site.models.*;
import me.hskwon.simple_shopping_site.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class GetProductServiceTest {
    private GetProductService getProductService;

    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);

        getProductService = new GetProductService(productRepository);
    }

    @Test
    @DisplayName("getProduct - existing")
    void testGetExistingProduct() {
        ProductId productId = new ProductId("id");

        Product product = new Product(
                productId,
                new CategoryId("id"),
                "name",
                new Money(1L),
                List.of(new Image(new ImageId("id"), "url"))
        );

        given(productRepository.findById(any()))
                .willReturn(Optional.of(product));

        Product found = getProductService.getProduct("id");

        verify(productRepository).findById(any());
    }

    @Test
    @DisplayName("getProduct - non-existent")
    void testGetNonExistentProduct() {
        ProductId productId = new ProductId("id");

        given(productRepository.findById(any()))
                .willReturn(Optional.empty());

        assertThatThrownBy(() -> getProductService.getProduct("id"))
                .isInstanceOf(RuntimeException.class);
    }
}