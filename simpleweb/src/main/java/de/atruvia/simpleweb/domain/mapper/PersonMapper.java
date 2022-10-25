package de.atruvia.simpleweb.domain.mapper;

import de.atruvia.simpleweb.domain.model.Person;
import de.atruvia.simpleweb.persistence.entities.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person convert(PersonEntity entity);
    PersonEntity convert(Person person);

    Iterable<Person> convert(Iterable<PersonEntity> entities);
}
