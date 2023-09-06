package ch.csbe.backendlb.resources.product;

import ch.csbe.backendlb.resources.category.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product create(Product product);
    Product getById(Long id);
    List<Product> getAll();
    Product update(Long id, Product product);
    void deleteById(Long id);
}

