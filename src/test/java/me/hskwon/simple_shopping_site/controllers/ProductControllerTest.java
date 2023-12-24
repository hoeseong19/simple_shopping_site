package me.hskwon.simple_shopping_site.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.hskwon.simple_shopping_site.application.categories.GetCategoryService;
import me.hskwon.simple_shopping_site.application.products.GetListProductService;
import me.hskwon.simple_shopping_site.dtos.ProductSummaryDto;
import me.hskwon.simple_shopping_site.models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    GetListProductService getListProductService;

    @MockBean
    GetCategoryService getCategoryService;

    @Test
    @DisplayName("GET /products - empty")
    void testGetEmptyListProduct() throws Exception {
        RequestBuilder requestBuilder = get("/products");

        given(getListProductService.getListProduct()).willReturn(List.of());

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("products")));

        verify(getListProductService).getListProduct();
        verify(getCategoryService, times(0)).getCategory(any());
    }

    @Test
    @DisplayName("GET /products")
    void testGetListProduct() throws Exception {
        RequestBuilder requestBuilder = get("/products");

        String json = """
                {
                     "id": "0BV000PRO0001",
                     "category": { "id": "0BV000CAT0001", "name": "top" },
                     "thumbnail": { "url": "https://ahastudio.github.io/my-image-assets/images/cbcl-products/01.jpg" },
                     "name": "CBCL 하트자수맨투맨",
                     "price": 128000
                 }
                """;

        ProductSummaryDto productSummaryDto = objectMapper.readValue(json, ProductSummaryDto.class);

        Product product = new Product(
                new ProductId(productSummaryDto.id()),
                new CategoryId(productSummaryDto.category().id()),
                productSummaryDto.name(),
                new Money(productSummaryDto.price()),
                List.of(new Image(new ImageId("id"), productSummaryDto.thumbnail().url()))
        );

        given(getListProductService.getListProduct()).willReturn(List.of(product));

        given(getCategoryService.getCategory(any())).willReturn(new Category(
                new CategoryId(productSummaryDto.category().id()),
                productSummaryDto.category().name()
        ));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("products")));

        verify(getListProductService).getListProduct();
        verify(getCategoryService).getCategory(any());
    }
}