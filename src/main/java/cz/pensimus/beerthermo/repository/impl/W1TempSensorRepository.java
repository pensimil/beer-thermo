package cz.pensimus.beerthermo.repository.impl;

import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.io.w1.W1Master;
import cz.pensimus.beerthermo.repository.TempSensorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Repository
public class W1TempSensorRepository implements TempSensorRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(W1TempSensorRepository.class);

    @Value("${w1.devices.path}")
    private String path;

    private W1Master w1Master;

    public BigDecimal readTemperature(@NonNull String sensor) {
        for (TemperatureSensor device : w1Master.getDevices(TemperatureSensor.class)) {
            if (sensor.equals(device.getName())) {
                return BigDecimal.valueOf(device.getTemperature());
            }
        }

        throw new RuntimeException(String.format("Unknown sensor %s.", sensor));
    }

    public List<String> getSensors() {
        return w1Master.getDevices(TemperatureSensor.class)
                .stream()
                .map(TemperatureSensor::getName)
                .collect(Collectors.toList());
    }


    @PostConstruct
    public void init() {
        this.w1Master = new W1Master(path);
    }
}
