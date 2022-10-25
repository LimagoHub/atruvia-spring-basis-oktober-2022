package de.atruvia.first.mail;

import de.atruvia.first.config.YamlPropertySourceFactory;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@Setter
@ConfigurationProperties(prefix = "mail")
@PropertySource(value= "classpath:mail.yaml",  factory = YamlPropertySourceFactory.class)
public class MailConfig {

    private String smtp;
    private String pop;
    private String user;
    private String passwort;

    @Bean
    @Qualifier("mail")
    public List<String> getData() {
        return List.of(smtp, pop,user, passwort);
    }
}
