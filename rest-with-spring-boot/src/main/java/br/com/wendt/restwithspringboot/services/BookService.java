package br.com.wendt.restwithspringboot.services;

import br.com.wendt.restwithspringboot.converter.DozerConverter;
import br.com.wendt.restwithspringboot.converter.custom.PersonConverter;
import br.com.wendt.restwithspringboot.data.model.Book;
import br.com.wendt.restwithspringboot.data.model.Person;
import br.com.wendt.restwithspringboot.data.vo.v1.BookVO;
import br.com.wendt.restwithspringboot.data.vo.v1.PersonVO;
import br.com.wendt.restwithspringboot.data.vo.v1.PersonVOV2;
import br.com.wendt.restwithspringboot.exception.ResourceNotFoundException;
import br.com.wendt.restwithspringboot.repository.BookRepository;
import br.com.wendt.restwithspringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PersonConverter converter;

    public BookVO create(BookVO book){
        var entity = DozerConverter.parseObject(book, Book.class);
        var vo = DozerConverter.parseObject(bookRepository.save(entity), BookVO.class);
        return vo;
    }

    public List<BookVO> findAll(){
        return DozerConverter.parseListObjects(bookRepository.findAll(), BookVO.class);
    }

    public BookVO findById(Long id) {

        var entity = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        return DozerConverter.parseObject(entity, BookVO.class);
    }

    public BookVO update(BookVO book){
        var entity = bookRepository.findById(book.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        var vo = DozerConverter.parseObject(bookRepository.save(entity), BookVO.class);
        return vo;
    }

    public void delete(Long id){
        Book entity = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        bookRepository.delete(entity);
    }
}
