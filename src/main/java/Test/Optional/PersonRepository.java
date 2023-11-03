package Test.Optional;

import java.util.Map;
import java.util.Optional;

public class PersonRepository {

    private final Map<Long, Person> persons;

    public PersonRepository(Map<Long, Person> persons) {
        this.persons = persons;
    }

    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(persons.get(id));
    }

}