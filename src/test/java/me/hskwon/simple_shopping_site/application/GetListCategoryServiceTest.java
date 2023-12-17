package me.hskwon.simple_shopping_site.application;

import jakarta.transaction.Transactional;
import me.hskwon.simple_shopping_site.application.categories.GetListCategoryService;
import me.hskwon.simple_shopping_site.models.Category;
import me.hskwon.simple_shopping_site.models.CategoryId;
import me.hskwon.simple_shopping_site.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
@Transactional
class GetListCategoryServiceTest {
    private CategoryRepository categoryRepository;

    private GetListCategoryService getListCategoryService;

    @BeforeEach
    void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        getListCategoryService = new GetListCategoryService(categoryRepository);
    }

    @Test
    @DisplayName("getList")
    public void testGetList() {
        Category category = new Category(new CategoryId("id"), "name");

        given(categoryRepository.findAll()).willReturn(List.of(category));

        List<Category> categories = getListCategoryService.getList();

        assertThat(categories).hasSize(1);

        verify(categoryRepository).findAll();
    }
}