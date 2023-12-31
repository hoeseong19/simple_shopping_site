package me.hskwon.simple_shopping_site.dtos;

import jakarta.validation.constraints.NotBlank;

public record AddProductToCartDto(
        @NotBlank
        String productId
) {
}
