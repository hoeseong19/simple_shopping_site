package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.categories.GetCategoryService;
import me.hskwon.simple_shopping_site.application.products.GetListProductService;
import me.hskwon.simple_shopping_site.dtos.ListProductDto;
import me.hskwon.simple_shopping_site.dtos.ProductSummaryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final GetListProductService getListProductService;

    private final GetCategoryService getCategoryService;

    public ProductController(GetListProductService getListProductService, GetCategoryService getCategoryService) {
        this.getListProductService = getListProductService;
        this.getCategoryService = getCategoryService;
    }

    @GetMapping()
    ListProductDto getListProduct() {
        List<ProductSummaryDto> products = getListProductService
                .getListProduct()
                .stream()
                .map(ProductSummaryDto::of)
                .toList();

        return new ListProductDto(products);
    }
}
