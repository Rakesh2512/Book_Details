package com.book.dao;

import com.book.entity.Book;
import com.book.row.mapper.BookRowMapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Boolean save(Book book) {
        String INSERT = "insert into book(book_id,book_name,author_name) values(?,?,?)";
        Integer save = jdbcTemplate.update(INSERT,book.getBook_id(),book.getBook_name(),book.getAuthor_name());
        return (save == 1)?Boolean.TRUE:Boolean.FALSE;
    }

    @Override
    public List<Book> getAll() {
        String FetchAll = "Select * from book";
        return jdbcTemplate.query(FetchAll, new BookRowMapper());
    }

    @Override
    public Book getById(Integer book_id) {
        String Fetch = "select * from book where book_id = "+book_id;
        return jdbcTemplate.queryForObject(Fetch,new BookRowMapper());
    }

    @Override
    public Boolean update(Book book) {
        String update = "update book set book_name = ?, author_name = ? where book_id =?";
        Integer x = jdbcTemplate.update(update,book.getBook_name(),book.getBook_name(),book.getBook_id());
        return (x == 1)?Boolean.TRUE: Boolean.FALSE;
    }

    @Override
    public Boolean delete(Integer book_id) {
        String delete = "delete from book where book_id = "+book_id;
        Integer  deleted = jdbcTemplate.update(delete);
        return (deleted == 1)?Boolean.TRUE:Boolean.FALSE;
    }
}
