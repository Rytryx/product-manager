package ch.csbe.backendlb.resources.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import ch.csbe.backendlb.resources.category.CategoryService;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {



    @Autowired
    CategoryRepository categoryRepository;



    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    public Category create(Category categoryToSave) {
        return this.categoryRepository.save(categoryToSave);
    }

    public Category getById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category with the id " + id + " could not be found!"));
    }

    public Category update(Long id, Category categoryToUpdate) {
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category with the id " + id + " could not be found!"));
        category.setName(categoryToUpdate.getName());
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Category with the id " + id + " could not be found!");
        }
    }
}
