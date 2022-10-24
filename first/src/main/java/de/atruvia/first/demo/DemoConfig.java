package de.atruvia.first.demo;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class DemoConfig {

    @Bean
    @Qualifier("namen")
    public List<String> findNamen() {
        return List.of("Peter","Paul","Mary");
    }

    @Bean
    @Qualifier("fruits")
    public List<String> fruits() {
        return List.of("Banana","Strawberry","Cherry");
    }

    @Bean
    public Demo createDemo(@Qualifier("mail") List<String> namen) {
        return new Demo(namen);
    }
}
