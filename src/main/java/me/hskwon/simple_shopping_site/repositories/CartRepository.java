package me.hskwon.simple_shopping_site.repositories;

import me.hskwon.simple_shopping_site.models.Cart;
import me.hskwon.simple_shopping_site.models.CartId;
import me.hskwon.simple_shopping_site.models.UserId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, CartId> {
    Optional<Cart> findByUserId(UserId userId);
}
