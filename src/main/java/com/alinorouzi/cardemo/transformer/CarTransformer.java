package com.alinorouzi.cardemo.transformer;

import com.alinorouzi.cardemo.dto.CarDto;
import com.alinorouzi.cardemo.dto.CarInfoDto;
import com.alinorouzi.cardemo.model.Car;
import com.alinorouzi.cardemo.model.Engine;
import com.alinorouzi.cardemo.model.Wheel;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarTransformer {
    private CarTransformer(){}
    public static CarDto toDto(Car car) {
        return CarDto
                .builder()
                .id(car.getId())
                .name(car.getName())
                .type(car.getType())
                .build();
    }

    public static CarInfoDto toInfoDto(Car car, List<Engine> allEnginesByCarId, List<Wheel> allWheelsByCarId) {
        return CarInfoDto
                .builder()
                .id(car.getId())
                .name(car.getName())
                .type(car.getType())
                .suitableWheels(allWheelsByCarId
                        .stream()
                        .map(CarPartTransformer::toWheelDto)
                        .collect(Collectors.toList()))
                .suitableEngines(allEnginesByCarId
                        .stream()
                        .map(CarPartTransformer::toEngineDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public static Car toModel(CarDto dto) {
        return Car
                .builder()
                .id(Optional.ofNullable(dto).map(CarDto::getId).orElse(null))
                .name(Objects.requireNonNull(dto).getName())
                .type(Objects.requireNonNull(dto).getType())
                .build();
    }
}
