package com.wild.milshakes.Milshake.entity;

import jakarta.persistence.*;

@Entity
public class Milkshake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private int quantity;
    @Column
    private String mainIngredient;

    public Milkshake(){}

    public Milkshake(String name, int quantity, String mainIngredient) {
        this.name = name;
        this.quantity = quantity;
        this.mainIngredient = mainIngredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }
}
