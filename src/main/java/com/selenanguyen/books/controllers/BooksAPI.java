package com.selenanguyen.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.selenanguyen.books.models.BooksModel;
import com.selenanguyen.books.services.BooksService;

@RestController
public class BooksAPI {
    private final BooksService booksService;
    public BooksAPI(BooksService booksService){
        this.booksService = booksService;
    }
    @RequestMapping("/api/books")
    public List<BooksModel> index() {
        return booksService.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public BooksModel create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        BooksModel book = new BooksModel(title, desc, lang, numOfPages);
        return booksService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public BooksModel show(@PathVariable("id") Long id) {
        BooksModel book = booksService.findBook(id);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public BooksModel update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
        BooksModel book = booksService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        booksService.deleteBook(id);
    }

}
