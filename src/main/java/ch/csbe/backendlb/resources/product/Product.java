package ch.csbe.backendlb.resources.product;

import io.micrometer.observation.transport.Propagator;
import jakarta.persistence.*;
import ch.csbe.backendlb.resources.category.Category;
import org.hibernate.property.access.spi.Setter;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition="varchar(100)")
    private String sku;
    @Column(columnDefinition="varchar(500)")
    private String name;
    @Column(columnDefinition="varchar(1000)")
    private String image;
    @Column(columnDefinition="MEDIUMTEXT")
    private String description;
    @Column(columnDefinition="FLOAT")
    private float price;
    @Column(columnDefinition="INT")
    private int stock;
    @ManyToOne()
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
