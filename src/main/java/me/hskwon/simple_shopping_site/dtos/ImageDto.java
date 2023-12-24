package me.hskwon.simple_shopping_site.dtos;

import me.hskwon.simple_shopping_site.models.Image;

public record ImageDto(
        String url
) {
    public static ImageDto of(Image image) {
        return new ImageDto(image.url());
    }
}
