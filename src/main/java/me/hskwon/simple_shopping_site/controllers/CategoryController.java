package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.dtos.ListCategoryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @GetMapping()
    public ListCategoryDto getList() {
        return new ListCategoryDto(List.of());
    }
}
