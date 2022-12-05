package ru.se4oev.web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "books")
    @SequenceGenerator(name = "books", sequenceName = "books_seq", allocationSize = 1)
    private Long id;

    private String author;

    private String title;

    private Double price;

}
