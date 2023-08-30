package ch.csbe.backendlb.resources.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsById(Long id);
    @Query("SELECT p FROM Product  p WHERE p.id= ?1")
    Product findProductById(Long id);
    @Query("UPDATE Product p SET p.name = ?2 WHERE p.id = ?1")
    @Modifying
    void updateProductNameById(Long id, String newName);
    @Query("DELETE FROM Product  p WHERE p.id= ?1")
    @Modifying
    Product deleteProductById(Long id);
}
