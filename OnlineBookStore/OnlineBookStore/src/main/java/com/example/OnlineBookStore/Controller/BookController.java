package com.example.OnlineBookStore.Controller;

import com.example.OnlineBookStore.Model.Book;
import com.example.OnlineBookStore.Repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@Tag(name = "Book Controller", description = "APIs for Book Management")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Operation(summary = "Add a new book", description = "saves a new book to the database")
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @Operation(summary = "Get all books", description = "Fetches the list of all available book")
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @Operation(summary = "Get a book by ID", description = "Fetches a book by its unique ID")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        if (!bookRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        book.setId(id);
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (!bookRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double rating) {

        List<Book> books;
        if (title != null) {
            books = bookRepository.findByBookTitle(title);
        } else if (author != null) {
            books = bookRepository.findByAuthorName(author);
        } else if (category != null) {
            books = bookRepository.findByCategory(category);
        } else if (rating != null) {
            books = bookRepository.findByRating(rating);
        } else {
            books = bookRepository.findAll();
        }
        return ResponseEntity.ok(books);
    }
}
