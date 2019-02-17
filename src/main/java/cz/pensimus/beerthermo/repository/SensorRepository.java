package cz.pensimus.beerthermo.repository;

import cz.pensimus.beerthermo.entity.Sensor;
import cz.pensimus.beerthermo.entity.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}
