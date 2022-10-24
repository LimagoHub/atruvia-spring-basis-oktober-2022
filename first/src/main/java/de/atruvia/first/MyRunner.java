package de.atruvia.first;

import de.atruvia.first.translator.Translator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(20)
@RequiredArgsConstructor
public class MyRunner implements CommandLineRunner {

    private final Translator translator;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(translator.translate("Hallo Welt"));
    }
}
