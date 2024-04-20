package br.unipe.reactiveclass.controller;

import br.unipe.reactiveclass.service.IntegrationService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@RestController
@RequestMapping("/integration")
public class IntegrationController {

    private final IntegrationService integrationService;


    @GetMapping
    public Flux<String> getCeps(){
        return integrationService.fetchDataFromMultipleSources();
    }

}
