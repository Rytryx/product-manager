package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findProductsByName(String name);
    @Query("SELECT c FROM Category  c WHERE c.name= ?1")
    Category findCategoryByTitle(String name);

    @Query("SELECT c FROM Category  c WHERE c.id= ?1")
    Category findCategoryById(long ind);
}
