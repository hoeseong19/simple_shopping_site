package me.hskwon.simple_shopping_site.application.categories;

import me.hskwon.simple_shopping_site.models.Category;
import me.hskwon.simple_shopping_site.models.CategoryId;
import me.hskwon.simple_shopping_site.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetCategoryServiceTest {
    private GetCategoryService getCategoryService;

    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryRepository = mock(CategoryRepository.class);

        getCategoryService = new GetCategoryService(categoryRepository);
    }

    @Test
    @DisplayName("getCategory - existing")
    void testGetExistingCategory() {
        CategoryId categoryId = new CategoryId("id");
        String mockCategoryName = "name";

        Category category = new Category(
                categoryId,
                mockCategoryName
        );

        given(categoryRepository.findById(categoryId)).willReturn(Optional.of(category));

        Category found = getCategoryService.getCategory(categoryId);

        verify(categoryRepository).findById(categoryId);

        assertThat(found.id()).isEqualTo(categoryId);
        assertThat(found.name()).isEqualTo(mockCategoryName);
    }

    @Test
    @DisplayName("getCategory - non-existent")
    void testGetNonExistentCategory() {
        CategoryId categoryId = new CategoryId("id");

        given(categoryRepository.findById(categoryId)).willReturn(Optional.empty());

        // id로 찾을 수 없으면 에러 발생
        assertThatThrownBy(() -> getCategoryService.getCategory(categoryId))
                .isInstanceOf(RuntimeException.class);

        verify(categoryRepository).findById(categoryId);
    }
}