package me.hskwon.simple_shopping_site.dtos;

import me.hskwon.simple_shopping_site.models.Product;

public record ProductSummaryDto(
        String id,
        String name,
        ImageDto thumbnail
) {
    public static ProductSummaryDto of(Product product) {
        return new ProductSummaryDto(
                product.id().toString(),
                product.name(),
                ImageDto.of(product.images().get(0))
        );
    }
}
