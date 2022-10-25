package de.atruvia.simpleweb.persistence.repositories;

import de.atruvia.simpleweb.persistence.entities.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonEntity, String> {

    Iterable<PersonEntity> findByVorname(String vorname);

}
