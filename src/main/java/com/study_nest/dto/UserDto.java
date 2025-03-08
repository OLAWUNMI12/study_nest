package com.study_nest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String firstName;

    private String lastName;

    private String email;

    private String courseOfStudy;

    private String institution;

    private Date createdAt;

    private Date updatedAt;

    private String token;

}
