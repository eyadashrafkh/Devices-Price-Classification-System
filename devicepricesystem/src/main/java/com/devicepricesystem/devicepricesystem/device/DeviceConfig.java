package com.devicepricesystem.devicepricesystem.device;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeviceConfig {

    @Bean
    CommandLineRunner commandLineRunner(DeviceRepository repository) {
        return args -> {
            Device device1 = new Device(1L, 1, 1, 1.0, 1, 1, 1, 1, 1.0, 1.0, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1,
                    1);
            Device device2 = new Device(2L, 2, 0, 2.0, 0, 2, 0, 2, 2.0, 2.0, 2, 2, 2, 2, 2, 2, 2, 2, 0,
                    0,
                    0, 2);

            repository.saveAll(
                    List.of(device1, device2));
        };
    }
}