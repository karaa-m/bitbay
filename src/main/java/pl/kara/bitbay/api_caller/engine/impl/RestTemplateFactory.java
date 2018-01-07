package pl.kara.bitbay.api_caller.engine.impl;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Fabryka RestTemplate tworzy springowego beana
 */
@Configuration
class RestTemplateFactory {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

}
