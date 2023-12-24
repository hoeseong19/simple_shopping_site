package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.categories.GetCategoryService;
import me.hskwon.simple_shopping_site.application.products.GetListProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    GetListProductService getListProductService;

    @MockBean
    GetCategoryService getCategoryService;

    @Test
    @DisplayName("GET /products")
    void testGetListProduct() throws Exception {
        RequestBuilder requestBuilder = get("/products");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("products")));

        verify(getListProductService).getListProduct();
    }
}