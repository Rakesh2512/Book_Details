package com.book.service;

import com.book.dao.BookDao;
import com.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;
    @Override
    public Boolean save(Book book) {

        return bookDao.save(book);
    }

    @Override
    public List<Book>getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book getById(Integer book_id) {
        return bookDao.getById(book_id);
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public Boolean delete(Integer book_id) {
        return bookDao.delete(book_id);
    }
}
