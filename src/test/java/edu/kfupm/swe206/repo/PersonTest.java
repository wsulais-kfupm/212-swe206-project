package edu.kfupm.swe206.repo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.AdditionalAnswers;

import edu.kfupm.swe206.model.Person;

@ExtendWith(MockitoExtension.class)
public class PersonTest {

    @Mock
    private PersonRepository persons;

    @Test
    public void savedUserNoJobs() {
        Person person = new Person("Ahmed", "Abdullah", new java.util.HashSet<>());
        when(persons.save(any(Person.class))).then(AdditionalAnswers.returnsFirstArg());
        assertTrue(persons.save(person).getJobs().isEmpty());
    }
}
