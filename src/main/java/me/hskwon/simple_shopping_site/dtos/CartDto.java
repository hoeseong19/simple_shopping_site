package me.hskwon.simple_shopping_site.dtos;

import java.util.List;

public record CartDto(
        List<LineItemDto> lineItems,
        long totalPrice
) {
    public record LineItemDto(
            String id,
            ProductDto product,
            List<OptionDto> options,
            long unitPrice,
            int quantity,
            long totalPrice
    ) {
    }

    public record ProductDto(
            String id,
            String name,
            ImageDto thumbnail
    ) {
    }

    public record ImageDto(
            String url
    ) {
    }

    public record OptionDto(
            String name,
            OptionItemDto item
    ) {
    }

    public record OptionItemDto(
            String name
    ) {
    }
}
