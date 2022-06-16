package com.alinorouzi.cardemo.service.interfaces;

import com.alinorouzi.cardemo.dto.WheelDto;
import com.alinorouzi.cardemo.model.Wheel;

import java.util.List;

public interface IWheelService {
    List<Wheel> findAllWheelsByCarId(Integer carId);

    WheelDto save(WheelDto dto, Integer carId);

    void delete(Integer id);
}
