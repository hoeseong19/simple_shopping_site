package me.hskwon.simple_shopping_site.controllers;

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

    public ProductController(GetListProductService getListProductService) {
        this.getListProductService = getListProductService;
    }

    @GetMapping()
    ListProductDto getListProduct() {
        List<ProductSummaryDto> products = getListProductService.getListProduct();

        return new ListProductDto(products);
    }
}
