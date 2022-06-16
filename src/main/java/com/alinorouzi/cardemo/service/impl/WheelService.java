package com.alinorouzi.cardemo.service.impl;

import com.alinorouzi.cardemo.dto.WheelDto;
import com.alinorouzi.cardemo.model.Wheel;
import com.alinorouzi.cardemo.repo.WheelRepository;
import com.alinorouzi.cardemo.service.interfaces.IWheelService;
import com.alinorouzi.cardemo.transformer.CarPartTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WheelService implements IWheelService {
    private final WheelRepository wheelRepository;

    @Override
    public List<Wheel> findAllWheelsByCarId(Integer carId) {
        return wheelRepository.findAllByCarId(carId);
    }

    @Override
    public WheelDto save(WheelDto dto, Integer carId) {
        return CarPartTransformer.toWheelDto(wheelRepository.save(CarPartTransformer.toWheelModel(dto, carId)));
    }

    @Override
    public void delete(Integer id) {
        wheelRepository.deleteById(id);
    }
}
