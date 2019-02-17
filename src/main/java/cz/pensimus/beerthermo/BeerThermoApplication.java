package cz.pensimus.beerthermo;

import cz.pensimus.beerthermo.configuration.DatabasePropertiesFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@SpringBootApplication
@EnableScheduling
public class BeerThermoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeerThermoApplication.class, args);
	}

    @Bean
    public DatabasePropertiesFactory systemProperties() {
        return new DatabasePropertiesFactory();
    }
}
