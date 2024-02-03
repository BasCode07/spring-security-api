package com.bascode.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "firstName can not be empty")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull(message = "lastName can not be empty")
    @Column(name = "last_name", nullable = false)
    private  String lastName;

    @NotNull
    private char gender;

    @NotNull(message = "Age can not be empty")
    @Max(value = 70,message = "Age must not be greater than 70")
    @Min(value = 18, message = "Age must not be lesser than 18")
    private int age;

    @Pattern(regexp = "^\\d{10}$", message = "invalid phone number entered")
    private String phone;

    @Email( message = "invalid email entered", regexp = "^[a-zA-Z0-9.!#$%&â\u0080\u0099*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "colum state can not be empty")
    private String state;

    @NotNull(message = "colum country can not be empty")
    private String country;

    @NotNull(message = "enter your social security number or any valid id number")
    @Column(nullable = false)
    private int csn;


}
