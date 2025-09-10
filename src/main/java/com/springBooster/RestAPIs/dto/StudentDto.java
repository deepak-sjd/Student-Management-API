package com.springBooster.RestAPIs.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// @Data
public class StudentDto {

    private Long id;
    private String name;
    private String email;
    private Long phone;
    private String address;
    private String state;
    private String city;
    private String hostelName;
    private String branch;
    private int semester;
    private String collageName;


}
