package ru.se4oev.website.data;

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
public class BookRequest {

    private String author;
    private String title;
    private Double price;

}
