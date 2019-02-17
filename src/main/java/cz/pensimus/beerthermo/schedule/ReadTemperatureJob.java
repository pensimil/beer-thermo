package cz.pensimus.beerthermo.schedule;

import cz.pensimus.beerthermo.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReadTemperatureJob {

    @Autowired
    private TemperatureService temperatureService;

    @Scheduled(fixedRateString = "${read.temperature.timeout}")
    private void executeTemperatureRead() {
        temperatureService.fetchTemperature();
    }
}
