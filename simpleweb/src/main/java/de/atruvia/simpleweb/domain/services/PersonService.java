package de.atruvia.simpleweb.domain.services;

import de.atruvia.simpleweb.domain.model.Person;

import java.util.Optional;

public interface PersonService {

    boolean speichern_oder_aendern(Person person) throws PersonenServiceException;
    boolean loeschen(String id)  throws PersonenServiceException;
    Optional<Person> sucheNachId(String id)  throws PersonenServiceException;
    Iterable<Person> sucheAlle()  throws PersonenServiceException;
}
