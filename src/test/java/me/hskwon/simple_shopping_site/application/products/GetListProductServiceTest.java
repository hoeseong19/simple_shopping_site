package me.hskwon.simple_shopping_site.application.products;

import me.hskwon.simple_shopping_site.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class GetListProductServiceTest {
    private ProductRepository productRepository;
    private GetListProductService getListProductService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        getListProductService = new GetListProductService(productRepository);
    }

    @Test
    @DisplayName("getListProduct")
    void testGetListProduct() {
        getListProductService.getListProduct();

        verify(productRepository).findAll();
    }
}