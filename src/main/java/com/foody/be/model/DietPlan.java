package com.foody.be.model;

import javax.persistence.*;

@Entity
@Table(name = "diet_plan")
public class DietPlan {

    public DietPlan(Integer id, Integer breakfastId, Integer lunchId, Integer dinnerId) {
        this.id = id;
        this.breakfastId = breakfastId;
        this.lunchId = lunchId;
        this.dinnerId = dinnerId;

    }

    public DietPlan(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "breakfast_id")
    private Integer breakfastId;

    @Column(name = "lunch_id")
    private Integer lunchId;

    @Column(name = "dinner_id")
    private Integer dinnerId;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBreakfastId() {
        return this.breakfastId;
    }

    public void setBreakfastId(Integer breakfastId) {
        this.breakfastId = breakfastId;
    }

    public Integer getLunchId() {
        return this.lunchId;
    }

    public void setLunchId(Integer lunchId) {
        this.lunchId = lunchId;
    }

    public Integer getDinnerId() {
        return this.dinnerId;
    }

    public void setDinnerId(Integer dinnerId) {
        this.dinnerId = dinnerId;
    }


}
