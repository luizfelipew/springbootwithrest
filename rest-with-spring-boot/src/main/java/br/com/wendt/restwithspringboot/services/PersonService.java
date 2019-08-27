package br.com.wendt.restwithspringboot.services;

import br.com.wendt.restwithspringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    public Person findById(String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Luiz");
        person.setLastName("Wendt");
        person.setAddress("Sao paulo - Brasil");
        person.setGender("Male");

        return person;
    }
}
