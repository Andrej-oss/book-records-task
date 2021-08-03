package com.ncdc.bookrecordstask.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncdc.bookrecordstask.entity.Book;
import com.ncdc.bookrecordstask.service.impl.BookService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @MockBean
    private BookService bookService;

    private List<Book> books;
    private Book book1;
    private Book book2;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void init() {
        books = new ArrayList<>();
        book1 = new Book(1, "Arthur Conan Doyle", "Great Adventure of Sharlok Holmes", 123213123L, new byte[]{1, 13, 5, 6, 7});
        book2 = new Book(2, "Stephen King", "Cujo", 0L, new byte[]{7, 5, 32, 90});
        books.add(book1);
        books.add(book2);
    }

    @Test
    public void givenNothingWhenGettingAllBooksWillReturnAllBooks() throws Exception {
        BDDMockito.when(bookService.getAllBookRecords()).thenReturn(books);

        mockMvc.perform(MockMvcRequestBuilders.get("/book"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(Arrays.asList(book1, book2))))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2));
    }

    @SneakyThrows
    @Test
    public void givenIdWhenGettingOneBookByIdWillReturnBook() {
        BDDMockito.when(bookService.getImageBookById(ArgumentMatchers.anyInt())).thenReturn(book1.getData());

        mockMvc.perform(MockMvcRequestBuilders.get("/book/image/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.IMAGE_JPEG));
    }

    @Test
    public void givenValidBookBodyWhenInsertingBookWillReturnBook() throws Exception {
        final Book book3 = new Book(3, "Bulgakov", "Master and Margarita", 354354L, new byte[]{2, 13, 5, 7, 4, 0});
        MockMultipartFile file = new MockMultipartFile(
                "image",
                "WX20180207-134704@2x.png",
                "image/png",
                "master.jpg".getBytes());
        books.add(book3);
        Mockito.when(bookService.saveBookRecord(any(Book.class), any(MultipartFile.class))).thenReturn(book3);

        mockMvc.perform(MockMvcRequestBuilders.multipart("/book").file(file)
                .flashAttr("book", book3))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
