package org.purpura.apipg.service.remote;

import jakarta.annotation.PostConstruct;
import org.purpura.apipg.dto.schemas.remote.EstoqueDownturn;
import org.purpura.apipg.dto.schemas.remote.ResiduoDownturnRequestDTO;
import org.purpura.apipg.exception.remote.ResiduoInsufficientStockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class MongoApiService {
    private final WebClient.Builder webClientBuilder;
    private WebClient webClient;

    @Value("${mongo.api.base-url:http://localhost:8081}")
    private String baseUrl;

    public MongoApiService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @PostConstruct
    private void initWebClient() {
        this.webClient = webClientBuilder
                .baseUrl(baseUrl)
                .build();
    }

    public void downturnStock(String cnpj, EstoqueDownturn estoqueDownturn) {
        List<EstoqueDownturn> estoqueDownturnList = List.of(estoqueDownturn);
        downturnStock(cnpj, new ResiduoDownturnRequestDTO(estoqueDownturnList));
    }

    public void downturnStock(String cnpj, ResiduoDownturnRequestDTO residuoDownturnRequestDTO) {
        webClient.post()
                .uri("/empresa/{cnpj}/residuo/downturn", cnpj)
                .headers(h -> h.setContentType(MediaType.APPLICATION_JSON))
                .bodyValue(residuoDownturnRequestDTO)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        clientResponse -> {
                            throw new ResiduoInsufficientStockException(clientResponse.bodyToMono(String.class).block());
                        })
                .onStatus(HttpStatusCode::is2xxSuccessful,
                        clientResponse -> {
                            clientResponse.bodyToMono(String.class).subscribe();
                            return null;
                        });
    }

}
