package me.hskwon.simple_shopping_site.application.products;

import me.hskwon.simple_shopping_site.models.Product;
import me.hskwon.simple_shopping_site.models.ProductId;
import me.hskwon.simple_shopping_site.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class GetProductService {
    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(String id) {
        return productRepository.findById(new ProductId(id))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }
}
