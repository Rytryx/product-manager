package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.Dto.CategoryUpdateDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.MappingTarget;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition="TINYINT")
    private int active;
    @Column(columnDefinition="varchar(255)")
    private String name;
}
