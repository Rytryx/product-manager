package ch.csbe.backendlb.resources.category;

import org.springframework.web.bind.annotation.*;

@RequestMapping("categories")
@RestController()
public class CategorieController {
    @GetMapping("/")
    public String getCategories() {
        return "Hier wären meine Produktkategorien";
    }

    @PostMapping("/")
    public String createCategories() {
        return "Hier kann eine Produktkategorie erstellt werden";
    }

    @GetMapping("/{Id}")
    public String getCategoryById(@PathVariable String Id) {
        return "Hier wären meine Produktkategorien mit der id: " + Id;
    }

    @PutMapping("/{Id}")
    public String putCategoryById(@PathVariable String Id) {
        return "Hier können meine Produktkategorien bearbeitet werden mit der id: " + Id;
    }

    @DeleteMapping("/{Id}")
    public String deleteCategoryById(@PathVariable String Id) {
        return "Hier können meine Produktkategorien gelöscht werden mit der id: " + Id;
    }
}
