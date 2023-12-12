package me.hskwon.simple_shopping_site.dtos;

import me.hskwon.simple_shopping_site.models.Category;

public record CategoryDto(
        String id,
        String name
) {
    public static CategoryDto of(Category category) {
        return new CategoryDto(category.id().toString(), category.name());
    }
}
