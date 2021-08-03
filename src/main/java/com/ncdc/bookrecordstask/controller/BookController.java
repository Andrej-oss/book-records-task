package com.ncdc.bookrecordstask.controller;

import com.ncdc.bookrecordstask.entity.Book;
import com.ncdc.bookrecordstask.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin("http://localhost:4200")
public class BookController {

    private IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }
    //entry point get by url /book to get all books
    @GetMapping(value = "/book")
    public List<Book> getAllBooks(){
        log.info("Handling /get all books");
        return bookService.getAllBookRecords();
    }
    //entry point get by url /book/{id} to get image book by book id
    @GetMapping(value = "/book/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageBookById(@PathVariable int id){
        log.info("Handling /get book image by id " + id);
        return bookService.getImageBookById(id);
    }
    //entry point post by url /book to save book
    @PostMapping(value = "/book", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Book addBook(Book book, MultipartFile image){
        log.info("Handling /post book with body " + book + "and image " + image.getOriginalFilename());
        return bookService.saveBookRecord(book, image);
    }
    //entry point put by url /book/{id} to update book by book id
    @PutMapping(value = "/book/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Book updateBook(@PathVariable int id, Book book, MultipartFile image){
        log.info("Handling /put book with id " + id + "and body " + book + "and image " + image.getOriginalFilename());
        return bookService.updateBookRecord(id, book, image);
    }
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable int id){
        log.info("Handling /delete book by id " + id);
        bookService.deleteBookRecord(id);
    }
}
