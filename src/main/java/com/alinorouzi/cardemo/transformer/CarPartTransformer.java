package com.alinorouzi.cardemo.transformer;

import com.alinorouzi.cardemo.dto.CarPartDto;
import com.alinorouzi.cardemo.dto.EngineDto;
import com.alinorouzi.cardemo.dto.WheelDto;
import com.alinorouzi.cardemo.model.Car;
import com.alinorouzi.cardemo.model.CarPart;
import com.alinorouzi.cardemo.model.Engine;
import com.alinorouzi.cardemo.model.Wheel;

public class CarPartTransformer {
    private CarPartTransformer(){}
    public static CarPartDto toCarPartDto(CarPart part) {
        return CarPartDto
                .builder()
                .id(part.getId())
                .name(part.getName())
                .build();
    }

    public static EngineDto toEngineDto(Engine engine) {
        return EngineDto
                .builder()
                .id(engine.getId())
                .name(engine.getName())
                .horsePower(engine.getHorsePower())
                .topSpeed(engine.getTopSpeed())
                .build();
    }

    public static Engine toEngineModel(EngineDto engine, Integer carId) {
        return Engine
                .builder()
                .id(engine.getId())
                .name(engine.getName())
                .horsePower(engine.getHorsePower())
                .topSpeed(engine.getTopSpeed())
                .car(Car.builder().id(carId).build())
                .build();
    }

    public static WheelDto toWheelDto(Wheel wheel) {
        return WheelDto
                .builder()
                .id(wheel.getId())
                .name(wheel.getName())
                .radios(wheel.getRadios())
                .build();
    }

    public static Wheel toWheelModel(WheelDto wheel, Integer carId) {
        return Wheel
                .builder()
                .id(wheel.getId())
                .name(wheel.getName())
                .radios(wheel.getRadios())
                .car(Car.builder().id(carId).build())
                .build();
    }
}
