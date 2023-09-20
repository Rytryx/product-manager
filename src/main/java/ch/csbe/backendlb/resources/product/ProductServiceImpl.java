package ch.csbe.backendlb.resources.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    // Autowire the ProductRepository for database operations.
    @Autowired
    private final ProductRepository productRepository;

    // Constructor to inject the ProductRepository.
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        // Retrieve a list of all products from the database.
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        // Try to find a product by its unique identifier.
        Optional<Product> productOptional = productRepository.findById(id);
        // Return the product if found, otherwise return null.
        return productOptional.orElse(null);
    }

    @Override
    public Product create(Product product) {
        // Save a new product to the database and return the saved product.
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        // Try to find a product by its unique identifier.
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            // If the product exists, update its properties with the new values.
            Product existingProduct = productOptional.get();
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            // Save the updated product to the database and return it.
            return productRepository.save(existingProduct);
        }
        return null; // You may consider throwing an exception here to indicate that the product was not found.
    }

    @Override
    public void deleteById(Long id) {
        if (productRepository.existsById(id)) {
            // If the product with the specified ID exists, delete it from the database.
            productRepository.deleteById(id);
        } else {
            // If the product does not exist, throw a ResourceNotFoundException.
            throw new ResourceNotFoundException("Product with the id " + id + " could not be found!");
        }
    }
}
