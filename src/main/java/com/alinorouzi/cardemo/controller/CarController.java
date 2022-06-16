package com.alinorouzi.cardemo.controller;

import com.alinorouzi.cardemo.dto.CarDto;
import com.alinorouzi.cardemo.dto.CarInfoDto;
import com.alinorouzi.cardemo.enums.CarType;
import com.alinorouzi.cardemo.service.interfaces.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car")
@RequiredArgsConstructor
public class CarController {
    private final ICarService carService;

    @PostMapping("save")
    public CarDto saveCar(@RequestBody CarDto carDto) {
        return carService.saveCar(carDto);
    }

    @GetMapping("find/all")
    public List<CarInfoDto> findAll() {
        return carService.findAllCars();
    }

    @GetMapping("find/by/type")
    public List<CarInfoDto> findAllByType(@RequestParam CarType type) {
        return carService.findAllCarsByType(type);
    }

    @GetMapping("find/by/id/{id}")
    public CarInfoDto findById(@PathVariable Integer id) {
        return carService.findCarById(id);
    }

    @DeleteMapping("remove/{id}")
    public void deleteCarById(@PathVariable Integer id) {
        carService.delete(id);
    }
}
