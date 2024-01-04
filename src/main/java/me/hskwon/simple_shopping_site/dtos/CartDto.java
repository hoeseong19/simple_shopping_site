package me.hskwon.simple_shopping_site.dtos;

import me.hskwon.simple_shopping_site.models.*;

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
        public static LineItemDto of(CartLineItem item, Product product) {
            List<OptionDto> options = item.optionIds().stream()
                    .map(optionId -> {
                        return OptionDto.of(optionId, item.optionItemId(optionId), product);
                    })
                    .toList();

            return new LineItemDto(
                    item.id().toString(),
                    ProductDto.of(product),
                    options,
                    product.price().asLong(),
                    item.quantity(),
                    product.price().times(item.quantity()).asLong()
            );
        }
    }

    public record ProductDto(
            String id,
            String name,
            ImageDto thumbnail
    ) {
        public static ProductDto of(Product product) {
            return new ProductDto(
                    product.id().toString(),
                    product.name(),
                    ImageDto.of(product.image(0))
            );
        }
    }

    public record ImageDto(
            String url
    ) {
        public static ImageDto of(Image image) {
            return new ImageDto(image.url());
        }
    }

    public record OptionDto(
            String name,
            OptionItemDto item
    ) {
        public static OptionDto of(
                ProductOptionId optionId,
                ProductOptionItemId optionItemId,
                Product product
        ) {
            ProductOption productOption = product.optionById(optionId);

            return new OptionDto(
                    productOption.name(),
                    OptionItemDto.of(
                            productOption.itemById(optionItemId)
                    )
            );
        }
    }

    public record OptionItemDto(
            String name
    ) {
        public static OptionItemDto of(ProductOptionItem item) {
            return new OptionItemDto(item.name());
        }
    }
}
