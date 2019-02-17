package cz.pensimus.beerthermo.repository;

import cz.pensimus.beerthermo.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, String> {
}
