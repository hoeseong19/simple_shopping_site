package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.categories.GetListCategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest extends ControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    GetListCategoryService getListCategoryService;

    @Test()
    @DisplayName("GET /categories")
    public void testGetList() throws Exception {
        RequestBuilder requestBuilder = get("/categories");

        given(getListCategoryService.getList()).willReturn(List.of());

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("categories")));
    }
}