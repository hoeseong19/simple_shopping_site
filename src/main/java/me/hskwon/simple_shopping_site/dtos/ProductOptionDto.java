package me.hskwon.simple_shopping_site.dtos;

import me.hskwon.simple_shopping_site.models.ProductOption;

import java.util.List;

public record ProductOptionDto(
        String id,
        String name,
        List<ProductOptionItemDto> items
) {
    public static ProductOptionDto of(ProductOption option) {
        return new ProductOptionDto(
                option.id().toString(),
                option.name(),
                option.items().stream().map(ProductOptionItemDto::of).toList()
        );
    }
}
