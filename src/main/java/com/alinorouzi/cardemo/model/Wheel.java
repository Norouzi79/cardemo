package com.alinorouzi.cardemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@NoArgsConstructor
@Accessors(chain = true)
public class Wheel extends CarPart {
    private Double radios;

    public Wheel(Integer id, String name, Car car, Double radios) {
        super(id, name, car);
        this.radios = radios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Wheel wheel = (Wheel) o;
        return getId() != null && Objects.equals(getId(), wheel.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
