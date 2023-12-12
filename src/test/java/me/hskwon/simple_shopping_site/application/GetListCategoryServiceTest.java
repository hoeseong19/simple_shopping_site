package me.hskwon.simple_shopping_site.application;

import me.hskwon.simple_shopping_site.models.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GetListCategoryServiceTest {
    private GetListCategoryService getListCategoryService;

    @BeforeEach
    void setUp() {
        getListCategoryService = new GetListCategoryService();
    }

    @Test
    @DisplayName("getList")
    public void testGetList() {
        List<Category> categories = getListCategoryService.getList();

        assertThat(categories).hasSize(1);
    }
}