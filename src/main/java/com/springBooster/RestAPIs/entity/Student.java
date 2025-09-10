package com.springBooster.RestAPIs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @NotBlank(message = "name must be required")
    @Size(min = 3,max = 30,message = "name should be min 4 character or max 30")
    @Column(name = "student_name")
    private String name;

    @NotBlank(message = "please enter email")
    @Email(message = "please enter email in correct format")
    private String email;

    @NotNull(message = "please enter phone")
    @Digits(integer = 10,fraction = 0,message = "phone must be 10 digits")
    private Long phone;

    @NotBlank(message = "address must be enter")
    @Size(min = 10,message = "address should be more than 10 character")
    private String address;

//    @NotBlank and @NotEmpty are only valid on Strings (CharSequence),
//    Collections, Maps, or Arrays, not on Long or primitive types.

    @NotEmpty(message = "state must be entered")
    private String state;

    @NotEmpty(message = "city must be entered")
    private String city;

    @NotEmpty(message = "hostelName must be entered")
    private String hostelName;

    private String branch;

    @Min(value = 1, message = "semester must be at least 1")
    @Max(value = 8,message = "semester cannot be more than 8")
    private int semester;

    @NotEmpty(message = "collageName must be entered")
    private String collageName;
}
