package com.foody.be.model.plan;

import javax.persistence.*;

@Entity
@Table(name = "lunch_v")
public class LunchV {
    public LunchV() {
    }

    public LunchV(String ch, String fat, String protein, String fruit, String vegetable) {
        this.ch = ch;
        this.fat = fat;
        this.protein = protein;
        this.fruit = fruit;
        this.vegetable = vegetable;
    }

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "ch")
    private String ch;

    @Column(name = "fat")
    private String fat;

    @Column(name = "protein")
    private String protein;

    @Column(name = "fruit")
    private String fruit;

    @Column(name = "vegetable")
    private String vegetable;

    @Column(name = "vitamin1")
    private String vitamin1;

    @Column(name = "vitamin2")
    private String vitamin2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVitamin1() {
        return vitamin1;
    }

    public void setVitamin1(String vitamin1) {
        this.vitamin1 = vitamin1;
    }

    public String getVitamin2() {
        return vitamin2;
    }

    public void setVitamin2(String vitamin2) {
        this.vitamin2 = vitamin2;
    }

    public String getCh() {
        return this.ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getFat() {
        return this.fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getProtein() {
        return this.protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getFruit() {
        return this.fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getVegetable() {
        return this.vegetable;
    }

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }
}
