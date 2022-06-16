package com.alinorouzi.cardemo.controller;

import com.alinorouzi.cardemo.dto.EngineDto;
import com.alinorouzi.cardemo.dto.WheelDto;
import com.alinorouzi.cardemo.service.interfaces.IEngineService;
import com.alinorouzi.cardemo.service.interfaces.IWheelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("car/part")
@RequiredArgsConstructor
public class CarPartController {
    private final IWheelService wheelService;
    private final IEngineService engineService;

    @PostMapping("save/wheel")
    public WheelDto saveCar(WheelDto dto, Integer carId) {
        return wheelService.save(dto, carId);
    }

    @PostMapping("save/engine")
    public EngineDto saveCar(EngineDto dto, Integer carId) {
        return engineService.save(dto, carId);
    }

    @DeleteMapping("remove/wheel")
    public void deleteWheelById(Integer id) {
        wheelService.delete(id);
    }

    @DeleteMapping("remove/engine")
    public void deleteEngineById(Integer id) {
        engineService.delete(id);
    }
}
