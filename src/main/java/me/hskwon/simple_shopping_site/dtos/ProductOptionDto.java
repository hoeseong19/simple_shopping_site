package me.hskwon.simple_shopping_site.dtos;

import me.hskwon.simple_shopping_site.models.ProductOption;

import java.util.List;
import java.util.stream.IntStream;

public record ProductOptionDto(
        String id,
        String name,
        List<ProductOptionItemDto> items
) {
    public static ProductOptionDto of(ProductOption option) {
        List<ProductOptionItemDto> items = IntStream.range(0, option.itemSize())
                .mapToObj(option::item)
                .map(ProductOptionItemDto::of)
                .toList();

        return new ProductOptionDto(
                option.id().toString(),
                option.name(),
                items
        );
    }
}
