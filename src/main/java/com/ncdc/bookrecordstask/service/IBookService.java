package com.ncdc.bookrecordstask.service;

import com.ncdc.bookrecordstask.entity.Book;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IBookService {

    List<Book> getAllBookRecords();
    Book saveBookRecord(Book book, MultipartFile image);
    byte[] getImageBookById(int id);
    Book updateBookRecord(int id, Book book, MultipartFile image);
    void deleteBookRecord(int id);
}
