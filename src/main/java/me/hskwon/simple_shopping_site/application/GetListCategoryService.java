package me.hskwon.simple_shopping_site.application;

import me.hskwon.simple_shopping_site.dtos.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetListCategoryService {
    public List<CategoryDto> getList() {
        return List.of();
    }
}
