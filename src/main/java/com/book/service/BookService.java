package com.book.service;

import com.book.entity.Book;

import java.util.List;

public interface BookService {

    public Boolean save(Book book);
    public List<Book> getAll();
    public Book getById(Integer book_id);
    public Boolean update(Book book);
    public Boolean delete(Integer book_id);
}
