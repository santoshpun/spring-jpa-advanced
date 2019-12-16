package com.santosh.springjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.springjpa.model.Book;
import com.santosh.springjpa.repo.BookRepository;

@RestController
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/")
	public ResponseEntity<?> getAllBooks() {
		List<Book> books = bookRepository.findAllBooks();
		return ResponseEntity.ok(books);
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<?> getBookById(@PathVariable("id") int id) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			Book bookObj = book.get();
			return ResponseEntity.ok(bookObj);
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/books/category/{id}")
	public ResponseEntity<?> getBookByCategoryId(@PathVariable("id") int id) {
		List<Book> books = bookRepository.getBooksByCategoryId(id);
		return ResponseEntity.ok(books);
	}

	@PostMapping("/books")
	public ResponseEntity<?> save(@RequestBody Book book) {
		bookRepository.save(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(book);
	}

}
