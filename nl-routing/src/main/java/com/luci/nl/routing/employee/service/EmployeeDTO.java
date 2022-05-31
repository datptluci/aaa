package com.luci.nl.routing.employee.service;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDTO {
    private Integer id;
    private String employeeCode;
    private String avatar;
    private String userName;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String sex;
    private Date dateOfBirth;
    private int citizenIdentification;
    private Date releaseDate;
    private String publishedPlace;
    private String address;
    private String accountStatus;
    private int parts;
    private String decentralization;
    private int project;
    private String permission;
    private String factorAuthentication;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String employeeCode, String avatar, String userName, String password, String firstName, String middleName, String lastName, String email, int phoneNumber, String sex, Date dateOfBirth, int citizenIdentification, Date releaseDate, String publishedPlace, String address, String accountStatus, int parts, String decentralization, int project, String permission, String factorAuthentication) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.avatar = avatar;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.citizenIdentification = citizenIdentification;
        this.releaseDate = releaseDate;
        this.publishedPlace = publishedPlace;
        this.address = address;
        this.accountStatus = accountStatus;
        this.parts = parts;
        this.decentralization = decentralization;
        this.project = project;
        this.permission = permission;
        this.factorAuthentication = factorAuthentication;
    }
}
