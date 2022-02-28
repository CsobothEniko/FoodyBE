package com.foody.be.dto;

import com.foody.be.model.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DietPlan {
    private Ch ch;
    private Fat fat;
    private Fruit fruit;
    private Protein protein;
    private Vegetable vegetable;
    private Vitamin vitamin;

    public DietPlan(Ch ch, Fat fat, Fruit fruit, Protein protein, Vegetable vegetable, Vitamin vitamin) {
        this.ch = ch;
        this.fat = fat;
        this.fruit = fruit;
        this.protein = protein;
        this.vegetable = vegetable;
        this.vitamin = vitamin;
    }
}
