package me.hskwon.simple_shopping_site;

import me.hskwon.simple_shopping_site.models.*;

import java.util.List;

public class Fixtures {
    public static Product product() {
        ProductId id = new ProductId("id");
        CategoryId categoryId = new CategoryId("categoryId");
        String name = "name";
        Money price = new Money(1L);
        List<Image> images = List.of(new Image(new ImageId("id"), "url"));

        Product product = new Product(id, categoryId, name, price, images);

        return product;
    }
}
