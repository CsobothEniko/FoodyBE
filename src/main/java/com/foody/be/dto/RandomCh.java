package com.foody.be.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RandomCh {
    private String name;
    private Integer quantity;
    private String quantityType ;
    private Integer calorie;
    //private String type;

    public RandomCh(String name, Integer quantity, String quantityType, Integer calorie) {
        this.name = name;
        this.quantity = quantity;
        this.quantityType = quantityType;
        this.calorie = calorie;
        //this.type = type;
    }
}
