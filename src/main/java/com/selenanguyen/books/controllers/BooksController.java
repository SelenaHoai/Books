package com.selenanguyen.books.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.selenanguyen.books.models.BooksModel;
import com.selenanguyen.books.services.BooksService;

@Controller
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	@RequestMapping("/books")
	public String dashboard(Model model) {

		ArrayList<BooksModel> books = (ArrayList<BooksModel>) booksService.allBooks();
		
		model.addAttribute("books", books);
		
		return "index.jsp";
	}
	
	@GetMapping("/books/{bookId}")
	public String show(Model model,@PathVariable("bookId") Long bookId) {
		
		System.out.println(bookId);
		BooksModel book = booksService.findBook(bookId);
		System.out.println(book);
		
//		ArrayList<BooksModel> books = (ArrayList<BooksModel>) booksService.allBooks();
		
		model.addAttribute("book", book);
//		model.addAttribute("books", books);
		
		return "show.jsp";
	}

}
