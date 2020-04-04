package de.keitocode.springbootraideriolib;

import de.keitocode.springbootraideriolib.service.RaiderioService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("de.keitocode.springbootraideriolib")
public class RaiderioLibConfig {

    @Bean
    public RaiderioLib raiderioLib() {
        return new RaiderioService();
    }
}