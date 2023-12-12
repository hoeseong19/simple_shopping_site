package me.hskwon.simple_shopping_site.application;

import me.hskwon.simple_shopping_site.models.Category;
import me.hskwon.simple_shopping_site.models.CategoryId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetListCategoryService {
    public List<Category> getList() {
        Category category = new Category(new CategoryId("id"), "name");

        return List.of(category);
    }
}
