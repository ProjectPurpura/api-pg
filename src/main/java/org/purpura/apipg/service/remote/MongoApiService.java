package org.purpura.apipg.service.remote;

import jakarta.annotation.PostConstruct;
import org.purpura.apipg.dto.schemas.remote.EstoqueDownturn;
import org.purpura.apipg.dto.schemas.remote.ResiduoDownturnRequestDTO;
import org.purpura.apipg.exception.ResiduoNotFoundException;
import org.purpura.apipg.exception.pedido.PedidoResiduoNotFoundException;
import org.purpura.apipg.exception.remote.ResiduoInsufficientStockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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

    public Mono<Void> downturnStock(String cnpj, EstoqueDownturn estoqueDownturn) {
        List<EstoqueDownturn> estoqueDownturnList = List.of(estoqueDownturn);
        return downturnStock(cnpj, new ResiduoDownturnRequestDTO(estoqueDownturnList));
    }

    public Mono<Void> downturnStock(String cnpj, ResiduoDownturnRequestDTO residuoDownturnRequestDTO) {
        return webClient.patch()
                .uri("/empresa/{cnpj}/residuo/downturn", cnpj)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(residuoDownturnRequestDTO)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode() == HttpStatus.NOT_FOUND) {
                        return clientResponse.bodyToMono(String.class)
                                .flatMap(body -> Mono.error(new ResiduoNotFoundException(body)));
                    } if (clientResponse.statusCode() == HttpStatus.BAD_REQUEST) {
                        return clientResponse.bodyToMono(String.class)
                                .flatMap(body -> Mono.error(new ResiduoInsufficientStockException(body)));
                    } else if (clientResponse.statusCode().is2xxSuccessful()) {
                        return clientResponse.bodyToMono(String.class).then(Mono.empty());
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                });
    }

}
