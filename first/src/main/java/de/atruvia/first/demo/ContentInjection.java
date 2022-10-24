package de.atruvia.first.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ContentInjection {


    private String content= "Alt"; // Field injection 2.0


    public ContentInjection( @Value("${ContentInjection.content}")String content) {// 1. Alt
        this.content = content;
        print();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @PostConstruct
    public final void print() {
        System.out.println(content);
    } // 3.
}
