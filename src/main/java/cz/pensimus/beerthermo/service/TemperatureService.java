package cz.pensimus.beerthermo.service;

import cz.pensimus.beerthermo.entity.Sensor;
import cz.pensimus.beerthermo.entity.Temperature;
import cz.pensimus.beerthermo.repository.SensorRepository;
import cz.pensimus.beerthermo.repository.TempSensorRepository;
import cz.pensimus.beerthermo.repository.TemperatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class TemperatureService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureService.class);

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private TempSensorRepository tempSensorRepository;

    @Autowired
    private SensorRepository sensorRepository;

    public List<Temperature> findAll() {
        return temperatureRepository.findAll();
    }

    @Transactional
    public void fetchTemperature() {
        for (Sensor sensor : sensorRepository.findAll()) {
            LOGGER.info("Reading temperature from sensor {}.", sensor.getName());
            BigDecimal temperature = tempSensorRepository.readTemperature(sensor.getIdentification());
            Temperature tempEntity = new Temperature();
            tempEntity.setValue(temperature);
            tempEntity.setCreated(new Date());
            tempEntity.setSensor(sensor);
            temperatureRepository.save(tempEntity);
            LOGGER.info("Reading temperature finished.");
        }
    }
}
