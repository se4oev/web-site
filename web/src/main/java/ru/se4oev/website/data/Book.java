package ru.se4oev.website.data;

import lombok.Value;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
@Value
public class Book {

    Long id;
    String author;
    String title;
    Double price;

}
