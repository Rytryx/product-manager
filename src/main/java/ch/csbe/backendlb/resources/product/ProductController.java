package ch.csbe.backendlb.resources.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getProducts() {
        return productService.getAll();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {
        productService.deleteById(id);
    }
}
