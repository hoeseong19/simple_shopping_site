package me.hskwon.simple_shopping_site.application.cart;

import me.hskwon.simple_shopping_site.dtos.CartDto;
import me.hskwon.simple_shopping_site.models.*;
import me.hskwon.simple_shopping_site.repositories.CartRepository;
import me.hskwon.simple_shopping_site.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class GetCartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public GetCartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public CartDto getCartDto(UserId userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElse(new Cart(CartId.generate(), userId));

        List<CartDto.LineItemDto> listItemDto = IntStream.range(0, cart.itemSize())
                .mapToObj(index -> {
                    CartLineItem item = cart.item(index);

                    Product product = productRepository.findById(item.productId())
                            .orElseThrow();

                    return CartDto.LineItemDto.of(item, product);
                })
                .toList();

        return new CartDto(listItemDto, 0L);
    }
}
