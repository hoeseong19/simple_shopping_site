package me.hskwon.simple_shopping_site.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record AddProductToCartDto(
        @NotBlank
        String productId,
        List<Option> options
) {
    public record Option(
            String id,
            String itemId
    ) {
    }
}
