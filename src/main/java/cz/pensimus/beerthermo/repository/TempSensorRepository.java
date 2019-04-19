package cz.pensimus.beerthermo.repository;

import java.math.BigDecimal;
import java.util.List;

public interface TempSensorRepository {
    BigDecimal readTemperature(String sensor);
    List<String> getSensors();
}
