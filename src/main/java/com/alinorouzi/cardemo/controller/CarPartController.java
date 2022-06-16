package com.alinorouzi.cardemo.controller;

import com.alinorouzi.cardemo.dto.EngineDto;
import com.alinorouzi.cardemo.dto.WheelDto;
import com.alinorouzi.cardemo.service.interfaces.IEngineService;
import com.alinorouzi.cardemo.service.interfaces.IWheelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("car/part")
@RequiredArgsConstructor
public class CarPartController {
    private final IWheelService wheelService;
    private final IEngineService engineService;

    @PostMapping("save/wheel")
    public WheelDto saveCar(@RequestBody WheelDto dto, @RequestParam Integer carId) {
        return wheelService.save(dto, carId);
    }

    @PostMapping("save/engine")
    public EngineDto saveCar(@RequestBody EngineDto dto, @RequestParam Integer carId) {
        return engineService.save(dto, carId);
    }

    @DeleteMapping("remove/wheel/{id}")
    public void deleteWheelById(@PathVariable Integer id) {
        wheelService.delete(id);
    }

    @DeleteMapping("remove/engine/{id}")
    public void deleteEngineById(@PathVariable Integer id) {
        engineService.delete(id);
    }
}
