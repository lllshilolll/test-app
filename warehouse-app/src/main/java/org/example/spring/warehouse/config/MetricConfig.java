package org.example.spring.warehouse.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricConfig {

    @Bean
    public TimedAspect prometheus(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

}
