package br.unipe.reactiveclass.service;

import br.unipe.reactiveclass.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@AllArgsConstructor
@Service
public class RecommendationService {


    public Flux<Book> getRecommendations(Long bookId) {
        return Flux.range(1, 100) // Simula 100 recomendações
                .map(this::createRecommendation)
                .delayElements(Duration.ofMillis(1)) // Simula um produtor rápido
                .subscribeOn(Schedulers.boundedElastic());
    }

    private Book createRecommendation(int id) {
        // Simula a criação de uma recomendação.
        return new Book((long) id, "Book Title " + id, "Author " + id);
    }
}
