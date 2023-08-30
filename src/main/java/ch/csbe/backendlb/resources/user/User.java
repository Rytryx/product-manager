package ch.csbe.backendlb.resources.user;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition="varchar(255)")
    private String username;
    @Column(columnDefinition="varchar(255)")
    private String password;
    @Column(columnDefinition="varchar(255)")
    private String surName;
    @Column(columnDefinition="varchar(255)")
    private String lastName;
    @Column(columnDefinition="varchar(255)")
    private String email;
    @Column(columnDefinition="DATE")
    private Date Birthday;
    @Column(columnDefinition="varchar(255)")
    private String streetName;
    @Column(columnDefinition="varchar(255)")
    private String streetNr;
    @Column(columnDefinition="varchar(10)")
    private String zipCode;
    @Column(columnDefinition="varchar(255)")
    private String city;
}
