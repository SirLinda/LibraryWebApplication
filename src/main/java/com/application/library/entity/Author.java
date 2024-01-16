package com.application.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100,
            nullable = false, unique = true)
    private String name;

    @Column(name = "discription", length = 250,
            nullable = false)
    private String description;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();

    public Author(final Long id, final String name,
                  final String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
