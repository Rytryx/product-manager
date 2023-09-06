package ch.csbe.backendlb.resources.product;

import io.micrometer.observation.transport.Propagator;
import jakarta.persistence.*;
import ch.csbe.backendlb.resources.category.Category;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
}
