package com.alinorouzi.cardemo.repo;

import com.alinorouzi.cardemo.enums.CarType;
import com.alinorouzi.cardemo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByType(CarType type);

    Optional<Car> findByName(String name);
}
