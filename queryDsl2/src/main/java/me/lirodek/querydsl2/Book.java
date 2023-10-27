package me.lirodek.querydsl2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id @GeneratedValue
    private Long id;
    private String title;
    @Lob
    private String content;
}
