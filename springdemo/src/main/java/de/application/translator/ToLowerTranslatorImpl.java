package de.application.translator;

public class ToLowerTranslatorImpl implements Translator{
    @Override
    public String translate(String message) {
        return message.toLowerCase();
    }
}
