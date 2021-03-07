package net.focik.gasconnection.domain;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GasConnectionConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
