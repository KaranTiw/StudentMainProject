package com.in.payload;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {


    private  Long id;

    @Size(min=3,message="Name is  at least 20 charecter ")
    private String name;

    @Email
    private String email;

    @Size(min=10,max=10,message="Mobile number is length 10 to mandatry")
    private String mobile;



}
