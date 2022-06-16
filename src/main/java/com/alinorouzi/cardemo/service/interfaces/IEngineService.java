package com.alinorouzi.cardemo.service.interfaces;

import com.alinorouzi.cardemo.dto.EngineDto;
import com.alinorouzi.cardemo.model.Engine;

import java.util.List;

public interface IEngineService {
    List<Engine> findAllEnginesByCarId(Integer carId);

    EngineDto save(EngineDto dto, Integer carId);

    void delete(Integer id);
}
