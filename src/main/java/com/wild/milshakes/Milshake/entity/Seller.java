package com.wild.milshakes.Milshake.entity;

import jakarta.persistence.*;


@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Seller(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Column
    private String name;


    public Seller(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column
    private int age;

}

