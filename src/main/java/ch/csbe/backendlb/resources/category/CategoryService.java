package ch.csbe.backendlb.resources.category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category create(Category category);
    Category getById(Long id);
    List<Category> getAll();
    Category update(Long id, Category category);
    void delete(Long id);
}

