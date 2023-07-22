package br.unipe.reactiveclass.model;// Classe de Entidade (Exemplo: Book.java)

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;

    // Construtores, getters e setters (omitidos para manter o exemplo conciso)
}
