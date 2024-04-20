package br.unipe.reactiveclass.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;

@AllArgsConstructor
@Service
public class IntegrationService {

    private final WebClient webClient;

    public Flux<String> fetchDataFromMultipleSources() {
        Flux<String> source1 = fetchData("https://viacep.com.br/ws/58031010/json");
        Flux<String> source2 = fetchData("https://viacep.com.br/ws/58031010/json");
        Flux<String> source3 = fetchData("http://localhost:9191/personagens");

        return Flux.merge(source1, source2, source3); // Combina os fluxos de dados
    }

    private Flux<String> fetchData(String uri) {
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(String.class)
                .retryWhen(Retry.backoff(3, Duration.ofSeconds(3))
                        .maxBackoff(Duration.ofSeconds(5))
                        .doBeforeRetry(retrySignal -> System.out.println("Retrying due to error: " + retrySignal.failure())))
                .onErrorResume(e -> Flux.just("Error occurred, default value returned."))
                .map(this::transformData); // Transformação dos dados
    }

    private String transformData(String data) {
        // Simulação de transformação de dados
        return "Processed: " + data;
    }
}


