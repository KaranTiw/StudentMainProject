package com.in.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name",nullable=false,length=100)
    private String title;


    @Column(name="salary",nullable=false,length=100)

    private String salary;

    @Column(name="age",nullable=false,length=100)

    private int Age;


    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;



}



