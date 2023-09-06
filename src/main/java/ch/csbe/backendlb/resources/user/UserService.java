package ch.csbe.backendlb.resources.user;

import ch.csbe.backendlb.resources.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(User user);
    User getById(Long id);
    List<User> getAll();
    User update(Long id, User user);
    void delete(Long id);
}

