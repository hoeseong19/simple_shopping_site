package me.hskwon.simple_shopping_site.application.categories;

import me.hskwon.simple_shopping_site.models.Category;
import me.hskwon.simple_shopping_site.models.CategoryId;
import me.hskwon.simple_shopping_site.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class GetCategoryService {
    private final CategoryRepository categoryRepository;

    public GetCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategory(CategoryId categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow();
    }
}
