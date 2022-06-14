package com.selenanguyen.books.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.selenanguyen.books.models.BooksModel;
import com.selenanguyen.books.repositories.BooksRepository;

@Service
public class BooksService {
    // adding the book repository as a dependency
    private final BooksRepository booksRepository;
    
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }
    // READ ALL
    public List<BooksModel> allBooks() {
        return booksRepository.findAll();
    }
    // CREATE ONE
    public BooksModel createBook(BooksModel b) {
        return booksRepository.save(b);
    }
    // READ ONE
    public BooksModel findBook(Long id) {
        Optional<BooksModel> optionalBook = booksRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // UPDATE ONE
	public BooksModel updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		BooksModel book = findBook(id);
		if(book != null) {
			book.setTitle(title);
			book.setDescription(desc);
			book.setLanguage(lang);
			book.setNumberOfPages(numOfPages);
		}
		return booksRepository.save(book);
	}
    
    // DELETE ONE
	public void deleteBook(Long id) {
		booksRepository.deleteById(id);
		
	}

}
