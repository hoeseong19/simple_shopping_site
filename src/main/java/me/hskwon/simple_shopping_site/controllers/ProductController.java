package me.hskwon.simple_shopping_site.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping()
    String getListProduct() {
        return """
                {
                    "products": []
                }
                """;
    }
}
