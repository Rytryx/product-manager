package ch.csbe.backendlb.resources.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity // Indicates that this class is an entity to be mapped to a database table
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Specifies the generation strategy for the primary key
    private Long id; // Unique identification number for the user

    @Column(columnDefinition = "varchar(255)")
    private String username; // User's username

    @Column(columnDefinition = "varchar(255)")
    private String password; // User's password

    @Column(columnDefinition = "varchar(255)")
    private String surname; // User's surname

    @Column(columnDefinition = "varchar(255)")
    private String lastname; // User's lastname

    @Column(columnDefinition = "varchar(255)")
    private String email; // User's email address

    @Column(columnDefinition = "DATE")
    private Date birthday; // User's birthday

    @Column(columnDefinition = "varchar(255)")
    private String streetName; // User's street name

    @Column(columnDefinition = "varchar(255)")
    private String streetNr; // User's street number

    @Column(columnDefinition = "varchar(10)")
    private String zipCode; // User's zip code

    @Column(columnDefinition = "varchar(255)")
    private String city; // User's city

    @Column(name = "role_id")
    private Long roleId; // Represents the user's role ID

}
