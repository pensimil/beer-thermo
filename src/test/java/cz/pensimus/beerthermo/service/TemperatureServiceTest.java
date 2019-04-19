package cz.pensimus.beerthermo.service;

import cz.pensimus.beerthermo.entity.Sensor;
import cz.pensimus.beerthermo.repository.SensorRepository;
import cz.pensimus.beerthermo.repository.TempSensorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemperatureServiceTest {

    @Mock
    private TempSensorRepository tempSensorRepositoryMock;

    @Autowired
    private TemperatureService temperatureService;

    @Autowired
    private SensorRepository sensorRepository;

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(temperatureService, "tempSensorRepository", tempSensorRepositoryMock);
    }

    @Test
    public void testInitSensors() {
        List<String> sensorStrings = Collections.singletonList("testSensorUnique");

        when(tempSensorRepositoryMock.getSensors()).thenReturn(sensorStrings);
        temperatureService.initSensors();
        temperatureService.initSensors();

        List<Sensor> sensors = sensorRepository.findAll();

        assertEquals(String.format("More sensors than expected. %s", sensors), 1, sensors.size());
        assertEquals(sensorStrings.get(0), sensors.get(0).getName());
        assertEquals(sensorStrings.get(0), sensors.get(0).getIdentification());
    }

}