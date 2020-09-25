package com.demo.pagedata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BackLogMassageDto {
    private String activity_name;
    private Integer typeNumber;

    @Override
    public String toString() {
        return "{ activity_name: "+activity_name+ "," +"typeNumber:"+typeNumber+"}";
    }
}
