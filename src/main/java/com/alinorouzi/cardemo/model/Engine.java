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
public class Engine extends CarPart {
    private Long horsePower;
    private Long topSpeed;

    public Engine(Integer id, String name, Car car, Long horsePower, Long topSpeed) {
        super(id, name, car);
        this.horsePower = horsePower;
        this.topSpeed = topSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Engine engine = (Engine) o;
        return getId() != null && Objects.equals(getId(), engine.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
