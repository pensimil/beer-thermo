package cz.pensimus.beerthermo.repository;

import cz.pensimus.beerthermo.entity.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
}
