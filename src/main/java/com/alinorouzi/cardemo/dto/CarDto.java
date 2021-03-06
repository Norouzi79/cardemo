package com.alinorouzi.cardemo.dto;

import com.alinorouzi.cardemo.enums.CarType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CarDto {
    private Integer id;
    private String name;
    private CarType type;
}
