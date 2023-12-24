package me.hskwon.simple_shopping_site.application.categories;

import me.hskwon.simple_shopping_site.models.Category;
import me.hskwon.simple_shopping_site.models.CategoryId;
import me.hskwon.simple_shopping_site.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class GetCategoryService {
    private final CategoryRepository categoryRepository;

    public GetCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategory(CategoryId categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }
}
