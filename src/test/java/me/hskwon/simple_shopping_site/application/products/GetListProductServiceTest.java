package me.hskwon.simple_shopping_site.application.products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GetListProductServiceTest {
    private GetListProductService getListProductService;

    @BeforeEach
    void setUp() {
        getListProductService = new GetListProductService();
    }

    @Test
    @DisplayName("getListProduct")
    void testGetListProduct() {
        getListProductService.getListProduct();
    }
}