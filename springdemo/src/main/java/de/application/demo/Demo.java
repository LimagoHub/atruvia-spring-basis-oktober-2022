package de.application.demo;

import de.application.translator.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Demo {

    private String message = "Hallo Demo";


    private final Translator translator;



    // Autowired implizit
    public Demo(@Qualifier("lower") final Translator translator) {  // 1.
        this.translator = translator;
        System.out.println("Constructor von Demo");
    }

    @PostConstruct
    public void init() { // 3.
        System.out.println(translator.translate("Init"));
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Und Tschuess");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(translator.translate(getMessage()));
    }
}
