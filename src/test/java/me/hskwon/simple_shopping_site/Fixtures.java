package me.hskwon.simple_shopping_site;

import me.hskwon.simple_shopping_site.models.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static Set<CartLineItemOption> options() {
        return new HashSet<CartLineItemOption>() {{
            add(new CartLineItemOption(
                    new ProductOptionId("productOptionId"),
                    new ProductOptionItemId("productOptionItemId")
            ));
        }};
    }
}
