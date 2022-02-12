package com.foody.be.model;

import javax.persistence.*;

@Entity
@Table(name = "ch")
public class Ch{
    public Ch(){
        //super();
    }

    public Ch(String name, Integer quantity, String quantityType, Integer calorie, String type) {
        //super();
        this.name = name;
        this.quantity = quantity;
        this.quantityType = quantityType;
        this.calorie = calorie;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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
