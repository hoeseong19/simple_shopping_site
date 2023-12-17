package me.hskwon.simple_shopping_site.application.categories;

import me.hskwon.simple_shopping_site.models.Category;
import me.hskwon.simple_shopping_site.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetListCategoryService {
    private final CategoryRepository categoryRepository;

    public GetListCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getList() {
        List<Category> categories = categoryRepository.findAll();

        return categories;
    }
}
