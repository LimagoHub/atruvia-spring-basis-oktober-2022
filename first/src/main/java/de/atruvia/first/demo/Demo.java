package de.atruvia.first.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;



public class Demo {

    private final List<String> namen;

    public Demo(@Qualifier("namen") List<String> namen) {
        this.namen = namen;
    }

    @PostConstruct
    public void print() {
        namen.forEach(System.out::println);
    }
}
