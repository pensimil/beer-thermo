package cz.pensimus.beerthermo.repository;

import java.math.BigDecimal;

public interface TempSensorRepository {
    BigDecimal readTemperature(String sensor);
}
