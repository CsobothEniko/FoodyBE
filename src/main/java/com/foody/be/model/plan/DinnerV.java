package com.foody.be.model.plan;

import javax.persistence.*;

@Entity
@Table(name = "dinner_v")
public class DinnerV {

    public DinnerV() {
    }

    public DinnerV(String ch, String fat, String protein, String fruit, String vegetable) {
        this.ch = ch;
        this.fat = fat;
        this.protein = protein;
        this.fruit = fruit;
        this.vegetable = vegetable;
    }

    @Id
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
