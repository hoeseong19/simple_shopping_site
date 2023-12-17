package me.hskwon.simple_shopping_site.application.products;

import me.hskwon.simple_shopping_site.dtos.ProductSummaryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetListProductService {
    public List<ProductSummaryDto> getListProduct() {
        return new ArrayList<>();
    }
}
