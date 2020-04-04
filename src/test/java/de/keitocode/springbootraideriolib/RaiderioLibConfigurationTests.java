package de.keitocode.springbootraideriolib;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import de.keitocode.springbootraideriolib.service.RaiderioService;

@SpringBootConfiguration
public class RaiderioLibConfigurationTests {
    @Bean
    public RaiderioLib raiderioLib() {
        return new RaiderioService();
    }
}