package com.alinorouzi.cardemo.service.impl;

import com.alinorouzi.cardemo.dto.EngineDto;
import com.alinorouzi.cardemo.model.Engine;
import com.alinorouzi.cardemo.repo.EngineRepository;
import com.alinorouzi.cardemo.service.interfaces.IEngineService;
import com.alinorouzi.cardemo.transformer.CarPartTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineService implements IEngineService {
    private final EngineRepository engineRepository;

    @Override
    public List<Engine> findAllEnginesByCarId(Integer carId) {
        return engineRepository.findAllByCarId(carId);
    }

    @Override
    public EngineDto save(EngineDto dto, Integer carId) {
        return CarPartTransformer.toEngineDto(engineRepository.save(CarPartTransformer.toEngineModel(dto, carId)));
    }

    @Override
    public void delete(Integer id) {
        engineRepository.deleteById(id);
    }
}
