package com.book.controller;

import com.book.entity.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public Boolean addBook(@RequestBody Book book){
        return bookService.save(book);
    }

    @GetMapping("/GetAll")
    public List<Book> bookList(){
        return bookService.getAll();
    }

    @GetMapping("/GetBook/{book_id}")
    public Book getById(@PathVariable Integer book_id){
        return bookService.getById(book_id);
    }

    @PutMapping("/update")
    public Boolean updateBook(@RequestBody Book book){
        return bookService.update(book);
    }

    @DeleteMapping("/delete/{book_id}")
    public Boolean deleteById(@PathVariable Integer book_id){
        return bookService.delete(book_id);
    }
}
