package me.hskwon.simple_shopping_site.dtos;

import me.hskwon.simple_shopping_site.models.Category;
import me.hskwon.simple_shopping_site.models.Product;

public record ProductSummaryDto(
        String id,
        String name,
        Long price,
        ImageDto thumbnail,
        CategoryDto category
) {
    public static ProductSummaryDto of(Product product, Category category) {
        return new ProductSummaryDto(
                product.id().toString(),
                product.name(),
                product.price().asLong(),
                ImageDto.of(product.images().get(0)),
                CategoryDto.of(category)
        );
    }
}
