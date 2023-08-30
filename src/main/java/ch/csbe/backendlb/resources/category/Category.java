package ch.csbe.backendlb.resources.category;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition="TINYINT")
    private int active;
    @Column(columnDefinition="varchar(255)")
    private String name;
}
