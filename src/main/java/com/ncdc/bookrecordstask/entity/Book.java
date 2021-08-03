package com.ncdc.bookrecordstask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Should be not empty")
    private String author;
    @NotEmpty(message = "Should be not empty")
    private String title;
    @Positive
    private Long ISBN;
    @Lob
    @JsonIgnore
    private byte[] data;

}
