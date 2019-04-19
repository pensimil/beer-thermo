package cz.pensimus.beerthermo.repository.impl;

import cz.pensimus.beerthermo.repository.TempSensorRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//@Primary
@Repository
public class GeneratedTempSensorRepository implements TempSensorRepository {
    @Override
    public BigDecimal readTemperature(String sensor) {
        return new BigDecimal("20");
    }

    @Override
    public List<String> getSensors() {
        return Collections.singletonList("test_sensor");
    }
}
