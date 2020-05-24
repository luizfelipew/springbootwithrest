package br.com.wendt.restwithspringboot.controller;

import br.com.wendt.restwithspringboot.data.vo.v1.BookVO;
import br.com.wendt.restwithspringboot.data.vo.v1.PersonVO;
import br.com.wendt.restwithspringboot.data.vo.v1.PersonVOV2;
import br.com.wendt.restwithspringboot.services.BookService;
import br.com.wendt.restwithspringboot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<BookVO> findAll() {
        List<BookVO> books = service.findAll();
        books
            .forEach(p -> p.add(
                linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()
                               )
             );
        return books;
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public BookVO findById(@PathVariable(value = "id") Long id) {
        BookVO bookVO = service.findById(id);
        bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return bookVO;
    }

    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
        consumes = {"application/json", "application/xml", "application/x-yaml"})
    public BookVO create(@RequestBody BookVO book) {
        BookVO bookVO = service.create(book);
        bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
        return bookVO;
    }

    @PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
        consumes = {"application/json", "application/xml", "application/x-yaml"})
    public BookVO update(@RequestBody BookVO book) {
        BookVO bookVO = service.update(book);
        bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
        return bookVO;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
