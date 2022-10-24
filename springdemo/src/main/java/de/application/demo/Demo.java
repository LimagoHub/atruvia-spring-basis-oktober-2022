package de.application.demo;

import de.application.translator.Translator;

public class Demo {

    private String message = "Hallo Demo";

    private final Translator translator;

//    public Translator getTranslator() {
//        return translator;
//    }
//
//    public void setTranslator(Translator translator) { // 2.
//        this.translator = translator;
//    }

    public Demo(final Translator upper) {  // 1.
        this.translator = upper;
        System.out.println(translator.translate("Constructor von Demo"));
    }

    public void init() { // 3.
        System.out.println(translator.translate("Init"));
    }
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
