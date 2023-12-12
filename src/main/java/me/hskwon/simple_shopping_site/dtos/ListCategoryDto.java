package me.hskwon.simple_shopping_site.dtos;

import java.util.List;

public record ListCategoryDto(
        List<CategoryDto> categories
) {
}
