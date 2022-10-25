package de.atruvia.simpleweb.domain.services.inner;

import de.atruvia.simpleweb.domain.mapper.PersonMapper;
import de.atruvia.simpleweb.domain.model.Person;
import de.atruvia.simpleweb.domain.services.PersonService;
import de.atruvia.simpleweb.domain.services.PersonenServiceException;
import de.atruvia.simpleweb.persistence.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = PersonenServiceException.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repo;
    private final PersonMapper mapper;

    private final List<String> antipathen;

    @Override
    public boolean speichern_oder_aendern(Person person) throws PersonenServiceException {

        try {
            if(person == null) throw new PersonenServiceException("Parameter darf nicht null sein");

            if(person.getVorname() == null || person.getVorname().length() < 2)
                throw new PersonenServiceException("Vorname zu kurz");

            if(person.getNachname() == null || person.getNachname().length() < 2)
                throw new PersonenServiceException("Nachname zu kurz");

            if(antipathen.contains(person.getVorname()))
                throw new PersonenServiceException("Antipath");

            boolean result = repo.existsById(person.getId());

            repo.save(mapper.convert(person));

            return result;
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Fehler im Service", e);
        }
    }

    @Override
    public boolean loeschen(String id) throws PersonenServiceException {
        try {
           if( repo.existsById(id)) {
                repo.deleteById(id);
                return  true;
            }
            return false;
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Fehler im Service", e);
        }
    }

    @Override
    public Optional<Person> sucheNachId(String id) throws PersonenServiceException {
        try {
            return repo.findById(id).map(mapper::convert);
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Fehler im Service", e);
        }
    }

    @Override
    public Iterable<Person> sucheAlle() throws PersonenServiceException {
        try {
            return mapper.convert(repo.findAll());
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Fehler im Service", e);
        }
    }
}
