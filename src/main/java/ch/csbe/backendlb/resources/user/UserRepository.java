package ch.csbe.backendlb.resources.user;

import ch.csbe.backendlb.resources.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findProductsById(Long id);
    @Query("SELECT u FROM User  u WHERE u.id= ?1")
    Product findToDoByLastName(Long id);

    User findByUsernameAndPassword(String username, String password);

    Optional<User> findByEmail(String email);
}
