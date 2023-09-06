package ch.csbe.backendlb.resources.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition="varchar(255)")
    private String username;
    @Column(columnDefinition="varchar(255)")
    private String password;
    @Column(columnDefinition="varchar(255)")
    private String surname;
    @Column(columnDefinition="varchar(255)")
    private String lastname;
    @Column(columnDefinition="varchar(255)")
    private String email;
    @Column(columnDefinition="DATE")
    private Date birthday;
    @Column(columnDefinition="varchar(255)")
    private String streetName;
    @Column(columnDefinition="varchar(255)")
    private String streetNr;
    @Column(columnDefinition="varchar(10)")
    private String zipCode;
    @Column(columnDefinition="varchar(255)")
    private String city;
}
