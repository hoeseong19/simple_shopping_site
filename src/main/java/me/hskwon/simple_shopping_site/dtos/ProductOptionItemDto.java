package me.hskwon.simple_shopping_site.dtos;

import me.hskwon.simple_shopping_site.models.ProductOptionItem;

public record ProductOptionItemDto(
        String id,
        String name
) {
    public static ProductOptionItemDto of(ProductOptionItem item) {
        return new ProductOptionItemDto(
                item.id().toString(),
                item.name()
        );
    }
}
