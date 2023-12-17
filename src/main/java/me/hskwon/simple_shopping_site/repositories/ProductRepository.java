package me.hskwon.simple_shopping_site.repositories;

import me.hskwon.simple_shopping_site.models.Product;
import me.hskwon.simple_shopping_site.models.ProductId;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, ProductId> {
}
