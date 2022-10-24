package de.atruvia.first.translator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class ToLowerTranslatorImpl implements Translator{
    @Override
    public String translate(String message) {
        return message.toLowerCase();
    }
}
