package cz.pensimus.beerthermo.repository.impl;

import cz.pensimus.beerthermo.repository.TempSensorRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class W1TempSensorRepository implements TempSensorRepository {
    @Override
    public BigDecimal readTemperature(String sensor) {
        throw new RuntimeException("Not supported method");
    }
}
