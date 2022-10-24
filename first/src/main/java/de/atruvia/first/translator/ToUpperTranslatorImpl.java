package de.atruvia.first.translator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("development")
public class ToUpperTranslatorImpl implements Translator{
    @Override
    public String translate(String message) {
        return message.toUpperCase();
    }
}
