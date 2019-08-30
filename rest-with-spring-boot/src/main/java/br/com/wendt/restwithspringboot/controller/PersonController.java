package br.com.wendt.restwithspringboot.controller;

import br.com.wendt.restwithspringboot.data.vo.PersonVO;
import br.com.wendt.restwithspringboot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public List<PersonVO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PersonVO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);

    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO personVO){
        return service.create(personVO);
    }

    @PutMapping
    public PersonVO update(@RequestBody PersonVO personVO){
        return service.update(personVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
