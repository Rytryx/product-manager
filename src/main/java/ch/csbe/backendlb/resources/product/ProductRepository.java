package ch.csbe.backendlb.resources.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing products.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Find products by their ID.
     *
     * @param id The ID to search for.
     * @return List of products with the specified ID.
     */
    List<Product> findProductsById(Long id);

    /**
     * Find a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The product with the specified ID.
     */
    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Product findProductById(Long id);

    /**
     * Update the name of a product by its ID.
     *
     * @param id      The ID of the product to update.
     * @param newName The new name for the product.
     */
    @Query("UPDATE Product p SET p.name = ?2 WHERE p.id = ?1")
    @Modifying
    void updateProductNameById(Long id, String newName);

    /**
     * Delete a product by its ID.
     *
     * @param id The ID of the product to delete.
     */
    @Query("DELETE FROM Product p WHERE p.id = ?1")
    @Modifying
    void deleteProductById(Long id);
}
