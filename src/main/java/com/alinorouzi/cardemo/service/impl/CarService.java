package com.alinorouzi.cardemo.service.impl;

import com.alinorouzi.cardemo.dto.CarDto;
import com.alinorouzi.cardemo.dto.CarInfoDto;
import com.alinorouzi.cardemo.enums.CarType;
import com.alinorouzi.cardemo.exception.CarNotFoundException;
import com.alinorouzi.cardemo.repo.CarRepository;
import com.alinorouzi.cardemo.service.interfaces.ICarService;
import com.alinorouzi.cardemo.service.interfaces.IEngineService;
import com.alinorouzi.cardemo.service.interfaces.IWheelService;
import com.alinorouzi.cardemo.transformer.CarTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {
    private final CarRepository carRepository;
    private final IEngineService engineService;
    private final IWheelService wheelService;

    @Override
    public CarDto saveCar(CarDto dto) {
        return CarTransformer.toDto(carRepository.save(CarTransformer.toModel(dto)));
    }

    @Override
    public List<CarInfoDto> findAllCarsByType(CarType type) {
        return carRepository.findAllByType(type)
                .stream()
                .map(car -> CarTransformer.toInfoDto(car, engineService.findAllEnginesByCarId(car.getId()), wheelService.findAllWheelsByCarId(car.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarInfoDto> findAllCars() {
        return carRepository.findAll()
                .stream()
                .map(car -> CarTransformer.toInfoDto(car, engineService.findAllEnginesByCarId(car.getId()), wheelService.findAllWheelsByCarId(car.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public CarInfoDto findCarById(Integer id) {
        return carRepository.findById(id)
                .map(car -> CarTransformer.toInfoDto(car, engineService.findAllEnginesByCarId(car.getId()), wheelService.findAllWheelsByCarId(car.getId())))
                .orElseThrow(() -> new CarNotFoundException("car not found"));
    }

    @Override
    public void delete(Integer id) {
        carRepository.deleteById(id);
    }
}
