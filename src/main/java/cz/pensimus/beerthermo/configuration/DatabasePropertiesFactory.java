package cz.pensimus.beerthermo.configuration;

import cz.pensimus.beerthermo.repository.ConfigurationRepository;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;


public class DatabasePropertiesFactory implements FactoryBean<Properties> {

    @Autowired
    private ConfigurationRepository configurationRepository;


    @Override
    public Properties getObject() {
        Properties properties = new Properties();
        configurationRepository.findAll()
                .forEach(item -> properties.setProperty(item.getName(), item.getValue()));

        return properties;
    }

    @Override
    public Class<?> getObjectType() {
        return Properties.class;
    }
}