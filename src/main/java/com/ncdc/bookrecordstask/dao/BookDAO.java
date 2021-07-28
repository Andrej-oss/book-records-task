package com.ncdc.bookrecordstask.dao;

import com.ncdc.bookrecordstask.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Integer> {
}
