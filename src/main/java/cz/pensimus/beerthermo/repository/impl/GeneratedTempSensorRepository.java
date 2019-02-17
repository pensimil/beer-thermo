package cz.pensimus.beerthermo.repository.impl;

import cz.pensimus.beerthermo.repository.TempSensorRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Primary
@Repository
public class GeneratedTempSensorRepository implements TempSensorRepository {
    @Override
    public BigDecimal readTemperature(String sensor) {
        return new BigDecimal("20");
    }
}
