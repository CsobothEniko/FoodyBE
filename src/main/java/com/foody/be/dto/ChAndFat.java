package com.foody.be.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ChAndFat {
    private String ChName;
    private String FatName;

    public ChAndFat(String ChName, String FatName) {
        this.ChName = ChName;
        this.FatName = FatName;
    }

}
