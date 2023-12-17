package me.hskwon.simple_shopping_site.application.products;

import me.hskwon.simple_shopping_site.models.Product;
import me.hskwon.simple_shopping_site.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetListProductService {
    private final ProductRepository productRepository;

    public GetListProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getListProduct() {
        List<Product> products = productRepository
                .findAll();

        return products;
    }
}
