package com.luci.nl.routing.employee.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique=true)
    private String employeeCode;
    @Column
    private String avatar;
    @Column(nullable = false, unique=true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String middleName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique=true)
    private String email;
    @Column(unique=true)
    private int phoneNumber;
    @Column
    private String sex;
    @Column
    private Date dateOfBirth;
    @Column(unique=true)
    private int citizenIdentification;
    @Column
    private Date releaseDate;
    @Column
    private String publishedPlace;
    @Column
    private String address;
    @Column
    private String accountStatus;
    @Column
    private int parts;
    @Column
    private String decentralization;
    @Column
    private int project;
    @Column
    private String permission;
    @Column
    private String factorAuthentication;
}

