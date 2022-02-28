package com.foody.be.model;

import javax.persistence.*;

@Entity
@Table(name = "plan")
public class Plan {

    public Plan(Integer id, Long chId, Long fatId, Long prId, Long frId, Long vegId, String type) {
        this.id = id;
        this.chId = chId;
        this.fatId = fatId;
        this.prId = prId;
        this.frId = frId;
        this.vegId = vegId;
        this.type = type;
    }

    public Plan(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ch_id")
    private Long chId;

    @Column(name = "fat_id")
    private Long fatId;

    @Column(name = "pr_id")
    private Long prId;

    @Column(name = "fr_id")
    private Long frId;

    @Column(name = "veg_id")
    private Long vegId;

    @Column(name = "type")
    private String type;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getChId() {
        return this.chId;
    }

    public void setChId(Long chId) {
        this.chId = chId;
    }

    public Long getFatId() {
        return this.fatId;
    }

    public void setFatId(Long fatId) {
        this.fatId = fatId;
    }

    public Long getPrId() {
        return this.prId;
    }

    public void setPrId(Long prId) {
        this.prId = prId;
    }

    public Long getFrId() {
        return this.frId;
    }

    public void setFrId(Long frId) {
        this.frId = frId;
    }

    public Long getVegId() {
        return this.vegId;
    }

    public void setVegId(Long vegId) {
        this.vegId = vegId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
