package com.foody.be.model.plan;

import javax.persistence.*;

@Entity
@Table(name = "breakfast")
public class Breakfast {
    public Breakfast(){}

    public Breakfast(Integer id, Integer chId, Integer fatId, Integer prId, Integer frId, Integer vegId, Integer vitaminId1, Integer vitaminid2, String day) {
        this.id = id;
        this.chId = chId;
        this.fatId = fatId;
        this.prId = prId;
        this.frId = frId;
        this.vegId = vegId;
        this.vitaminId1 = vitaminId1;
        this.vitaminid2 = vitaminid2;
        this.day = day;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ch_id")
    private Integer chId;

    @Column(name = "fat_id")
    private Integer fatId;

    @Column(name = "pr_id")
    private Integer prId;

    @Column(name = "fr_id")
    private Integer frId;

    @Column(name = "veg_id")
    private Integer vegId;

    @Column(name = "vitamin_id1")
    private Integer vitaminId1;

    @Column(name = "vitaminid2")
    private Integer vitaminid2;

    @Column(name = "day")
    private String day;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChId() {
        return this.chId;
    }

    public void setChId(Integer chId) {
        this.chId = chId;
    }

    public Integer getFatId() {
        return this.fatId;
    }

    public void setFatId(Integer fatId) {
        this.fatId = fatId;
    }

    public Integer getPrId() {
        return this.prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }

    public Integer getFrId() {
        return this.frId;
    }

    public void setFrId(Integer frId) {
        this.frId = frId;
    }

    public Integer getVegId() {
        return this.vegId;
    }

    public void setVegId(Integer vegId) {
        this.vegId = vegId;
    }

    public Integer getVitaminId1() {
        return this.vitaminId1;
    }

    public void setVitaminId1(Integer vitaminId1) {
        this.vitaminId1 = vitaminId1;
    }

    public Integer getVitaminid2() {
        return this.vitaminid2;
    }

    public void setVitaminid2(Integer vitaminid2) {
        this.vitaminid2 = vitaminid2;
    }
}
