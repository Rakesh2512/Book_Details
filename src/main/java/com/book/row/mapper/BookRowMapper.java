package com.book.row.mapper;

import com.book.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper <Book>{

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBook_id(rs.getInt("book_id"));
        book.setBook_name(rs.getString("book_name"));
        book.setAuthor_name(rs.getString("author_name"));
        return book;
    }
}
