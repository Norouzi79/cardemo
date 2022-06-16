package com.alinorouzi.cardemo.enums;

import com.alinorouzi.cardemo.exception.TypeNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CarType {
    ELECTRIC(1, "electric"),
    TWOWHEELS(2, "two wheels"),
    SPORT(3, "name");

    private final Integer value;
    private final String name;

    public static CarType getType(Integer value) {
        return Arrays.stream(CarType.values())
                .filter(type -> type.value.equals(value))
                .findAny()
                .orElseThrow(() -> new TypeNotFoundException("car type not found"));
    }

    public static CarType getType(String value) {
        return Arrays.stream(CarType.values())
                .filter(type -> type.name.equals(value))
                .findAny()
                .orElseThrow(() -> new TypeNotFoundException("car type not found"));
    }
}
