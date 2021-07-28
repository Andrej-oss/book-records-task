package com.ncdc.bookrecordstask.dao;

import com.ncdc.bookrecordstask.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookDAO extends JpaRepository<Book, Integer> {

}
