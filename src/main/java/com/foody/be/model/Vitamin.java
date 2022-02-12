package com.foody.be.model;

import javax.persistence.*;

@Entity
@Table(name = "vitamin")
public class Vitamin {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "quantity_type")
    private String quantityType;

    @Column(name = "calorie")
    private Integer calorie;

    @Column(name = "type")
    private String type;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getQuantityType() {
        return this.quantityType;
    }

    public void setQuantityType(String quantityType) {
        this.quantityType = quantityType;
    }

    public Integer getCalorie() {
        return this.calorie;
    }

    public void setCalorie(Integer calorie) {
        this.calorie = calorie;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
