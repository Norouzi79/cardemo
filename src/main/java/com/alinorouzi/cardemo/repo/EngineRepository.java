package com.alinorouzi.cardemo.repo;

import com.alinorouzi.cardemo.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Integer> {
    List<Engine> findAllByHorsePower(Long power);

    List<Engine> findAllByTopSpeed(Long speed);

    List<Engine> findAllByCarId(Integer id);

    Optional<Engine> findByName(String name);
}
