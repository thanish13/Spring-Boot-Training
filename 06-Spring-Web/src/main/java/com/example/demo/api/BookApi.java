package com.example.demo.api;

import com.example.demo.model.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book API", description = "Operations related to books")
public interface BookApi {


    @GetMapping
    @Operation(summary = "Get all books", description = "Returns a list of all available books")
    public ResponseEntity<?> getAllBooks();

    @GetMapping("/{id}")
    @Operation(summary = "Get a book by ID", description = "Retrieves a book by its unique ID")
    ResponseEntity<?> getBookById(@PathVariable Long id);

    @PostMapping
    @Operation(summary = "Add a new book", description = "Creates a new book entry")
    ResponseEntity<?> createBook(@RequestBody Book book);

    @PutMapping("/{id}")
    @Operation(summary = "Update a book", description = "Updates the details of an existing book")
    ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody Book book);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a book", description = "Deletes a book by its ID")
    ResponseEntity<?> deleteBook(@PathVariable Long id);
}
