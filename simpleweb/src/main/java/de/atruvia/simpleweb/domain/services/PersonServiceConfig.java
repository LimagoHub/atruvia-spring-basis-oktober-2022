package de.atruvia.simpleweb.domain.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonServiceConfig
{

    @Bean
    public List<String> antipathen() {
        return List.of("Attila", "Peter", "Paul", "Mary");
    }
}
