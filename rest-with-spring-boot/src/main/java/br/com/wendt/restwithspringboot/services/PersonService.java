package br.com.wendt.restwithspringboot.services;

import br.com.wendt.restwithspringboot.exception.ResourceNotFoundException;
import br.com.wendt.restwithspringboot.model.Person;
import br.com.wendt.restwithspringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person create(Person person){
        return personRepository.save(person);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
    }

    public Person update(Person person){
        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return personRepository.save(entity);
    }

    public void delete(Long id){
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        personRepository.delete(entity);
    }
}
