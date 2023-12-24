package me.hskwon.simple_shopping_site.dtos;

import me.hskwon.simple_shopping_site.models.Product;

public record ProductDetailDto(
        String id
) {
    public static ProductDetailDto of(Product product) {
        return new ProductDetailDto(
                product.id().toString()
        );
    }
}
