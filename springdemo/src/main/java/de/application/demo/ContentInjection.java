package de.application.demo;

public class ContentInjection {

    private String content= "Alt";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println(content);
    }
}
