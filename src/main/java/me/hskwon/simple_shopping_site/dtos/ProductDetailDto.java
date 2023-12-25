package me.hskwon.simple_shopping_site.dtos;

import me.hskwon.simple_shopping_site.models.Category;
import me.hskwon.simple_shopping_site.models.Product;

import java.util.List;

public record ProductDetailDto(
        String id,
        CategoryDto category,
        List<ImageDto> images,
        String name,
        Long price,
        List<ProductOptionDto> options,
        String description
) {
    public static ProductDetailDto of(Product product, Category category) {
        return new ProductDetailDto(
                product.id().toString(),
                CategoryDto.of(category),
                product.images().stream().map(ImageDto::of).toList(),
                product.name(),
                product.price().asLong(),
                product.options().stream().map(ProductOptionDto::of).toList(),
                product.description()
        );
    }
}
