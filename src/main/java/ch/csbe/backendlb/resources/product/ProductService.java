package ch.csbe.backendlb.resources.product;

import java.util.List;

/**
 * The ProductService interface defines the contract for managing products in the application.
 * It provides methods for creating, retrieving, updating, and deleting products.
 */
public interface ProductService {

    /**
     * Creates a new product.
     *
     * @param product The product to be created.
     * @return The created product.
     */
    Product create(Product product);

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @return The product with the specified ID if found, otherwise null.
     */
    Product getById(Long id);

    /**
     * Retrieves a list of all products in the system.
     *
     * @return A list of products.
     */
    List<Product> getAll();

    /**
     * Updates an existing product with new information.
     *
     * @param id      The unique identifier of the product to be updated.
     * @param product The updated product information.
     * @return The updated product.
     */
    Product update(Long id, Product product);

    /**
     * Deletes a product by its unique identifier.
     *
     * @param id The unique identifier of the product to be deleted.
     */
    void deleteById(Long id);
}
