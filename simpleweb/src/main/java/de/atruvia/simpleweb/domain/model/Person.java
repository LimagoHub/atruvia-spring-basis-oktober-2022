package de.atruvia.simpleweb.domain.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Person {

    @Setter(AccessLevel.PRIVATE)
    private String id;

    @Setter(AccessLevel.PRIVATE)
    private String vorname;

    private String nachname;

    public void taufen(String vorname) {
        this.vorname = vorname;
    }


}
