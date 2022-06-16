package com.alinorouzi.cardemo.repo;

import com.alinorouzi.cardemo.model.Wheel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WheelRepository extends JpaRepository<Wheel, Integer> {
    List<Wheel> findAllByRadios(Double radios);

    List<Wheel> findAllByCarId(Integer id);

    Optional<Wheel> findByName(String name);
}
