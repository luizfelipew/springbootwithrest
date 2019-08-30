package br.com.wendt.restwithspringboot.services;

import br.com.wendt.restwithspringboot.converter.DozerConverter;
import br.com.wendt.restwithspringboot.data.vo.PersonVO;
import br.com.wendt.restwithspringboot.exception.ResourceNotFoundException;
import br.com.wendt.restwithspringboot.data.model.Person;
import br.com.wendt.restwithspringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonVO create(PersonVO person){
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public List<PersonVO> findAll(){
        return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {

        var entity =  personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO person){
        var entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id){
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        personRepository.delete(entity);
    }
}
