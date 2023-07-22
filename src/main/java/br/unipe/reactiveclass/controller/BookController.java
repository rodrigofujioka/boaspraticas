package br.unipe.reactiveclass.controller;

// Controlador REST (Exemplo: BookController.java)
import br.unipe.reactiveclass.model.Book;
import br.unipe.reactiveclass.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookRepository bookRepository;


    // Endpoint para buscar todos os livros
    @GetMapping
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Endpoint para buscar um livro por ID
    @GetMapping("/{id}")
    public Mono<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    // Endpoint para adicionar um novo livro
    @PostMapping
    public Mono<Book> addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Endpoint para atualizar um livro existente
    @PutMapping("/{id}")
    public Mono<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookRepository.findById(id)
                .flatMap(existingBook -> {
                    existingBook.setTitle(book.getTitle());
                    existingBook.setAuthor(book.getAuthor());
                    return bookRepository.save(existingBook);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Livro não encontrado com o ID: " + id)));
    }

    // Endpoint para excluir um livro por ID
    @DeleteMapping("/{id}")
    public Mono<Void> deleteBook(@PathVariable Long id) {
        return bookRepository.deleteById(id);
    }
}
