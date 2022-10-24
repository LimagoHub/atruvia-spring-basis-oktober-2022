package de.application.translator;

public class ToUpperTranslatorImpl implements Translator{
    @Override
    public String translate(String message) {
        return message.toUpperCase();
    }
}
