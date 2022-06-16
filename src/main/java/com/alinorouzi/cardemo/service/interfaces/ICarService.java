package com.alinorouzi.cardemo.service.interfaces;

import com.alinorouzi.cardemo.dto.CarDto;
import com.alinorouzi.cardemo.dto.CarInfoDto;
import com.alinorouzi.cardemo.enums.CarType;

import java.util.List;

public interface ICarService {
    CarDto saveCar(CarDto dto);

    List<CarInfoDto> findAllCarsByType(CarType type);

    List<CarInfoDto> findAllCars();

    CarInfoDto findCarById(Integer id);

    void delete(Integer id);
}
