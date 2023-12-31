package me.hskwon.simple_shopping_site.repositories;

import me.hskwon.simple_shopping_site.models.Cart;
import me.hskwon.simple_shopping_site.models.CartId;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, CartId> {
}
