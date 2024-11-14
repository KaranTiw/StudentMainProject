package com.in.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id", nullable = false)

@GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false,length = 148)

    private String name;

    @Column(name = "email", nullable = false,length = 148,unique=true)
    private String email;

    @Column(name = "mobile", nullable = false,length = 10,unique=true)
    private String mobile;


}