package de.atruvia.simpleweb.presentation.mapper;


import de.atruvia.simpleweb.domain.model.Person;
import de.atruvia.simpleweb.presentation.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonDtoMapper {

    PersonDto convert(Person person);
    Person convert(PersonDto person);
    Iterable<PersonDto> convert(Iterable<Person> personen);
}
