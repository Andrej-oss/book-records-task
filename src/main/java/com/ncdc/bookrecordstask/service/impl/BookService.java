package com.ncdc.bookrecordstask.service.impl;

import com.ncdc.bookrecordstask.dao.BookDAO;
import com.ncdc.bookrecordstask.entity.Book;
import com.ncdc.bookrecordstask.exception.LetterAException;
import com.ncdc.bookrecordstask.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService implements IBookService {

    private BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> getAllBookRecords() {
        return Optional.of(bookDAO.findAll()).get();
    }

    @Override
    public Book saveBookRecord(Book book, MultipartFile image) {
        if (book != null){

            if (!book.getAuthor().startsWith("A")) throw new LetterAException("Please enter a valid value for author name, should start with \"A\"");
            if (image != null){
                try {
                    book.setData(image.getBytes());
                } catch (IOException e) {
                    log.warn("Unable to copy file " + image.getOriginalFilename() + " " + e.getMessage());
                }
            }
            bookDAO.save(book);
        }
        return book;
    }

    @Override
    public Book updateBookRecord(int id, Book book, MultipartFile image) {
        return null;
    }

    @Override
    public void deleteBookRecord(int id) {
        final Book book = Optional.of(bookDAO.getById(id)).get();
        bookDAO.delete(book);
    }

    @Override
    public byte[] getImageBookById(int id) {
        return Optional.of(bookDAO.getById(id).getData()).get();
    }
}
