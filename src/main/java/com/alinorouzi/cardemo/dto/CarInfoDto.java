package com.alinorouzi.cardemo.dto;

import com.alinorouzi.cardemo.enums.CarType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CarInfoDto {
    private Integer id;
    private String name;
    private CarType type;
    private List<WheelDto> suitableWheels = new ArrayList<>();
    private List<EngineDto> suitableEngines = new ArrayList<>();
}
