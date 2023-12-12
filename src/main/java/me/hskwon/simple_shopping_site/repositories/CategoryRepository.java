package me.hskwon.simple_shopping_site.repositories;

import me.hskwon.simple_shopping_site.models.Category;
import me.hskwon.simple_shopping_site.models.CategoryId;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, CategoryId> {
}
