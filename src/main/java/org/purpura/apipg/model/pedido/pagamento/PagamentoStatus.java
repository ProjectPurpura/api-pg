package org.purpura.apipg.model.pedido.pagamento;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.purpura.apipg.model.pedido.pagamento.state.CanceladoState;
import org.purpura.apipg.model.pedido.pagamento.state.ConcluidoState;
import org.purpura.apipg.model.pedido.pagamento.state.PagamentoState;
import org.purpura.apipg.model.pedido.pagamento.state.PendenteState;
import org.purpura.apipg.util.enums.GenericEnumConverter;
import org.purpura.apipg.util.enums.ValuedEnum;

public enum PagamentoStatus implements ValuedEnum<String> {
    PENDENTE("pendente"),
    CONCLUIDO("concluído"),
    CANCELADO("cancelado");

    private final String value;

    PagamentoStatus(String value) { this.value = value; }

    @Override
    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static PagamentoStatus fromValue(String value) {
        return GenericEnumConverter.fromValue(PagamentoStatus.class, value);
    }

    public static class Converter extends GenericEnumConverter<PagamentoStatus, String> {
        public Converter() {
            super(PagamentoStatus.class);
        }
    }

    public record Adapter(PagamentoStatus status) {
        public PagamentoState toState() {
            switch (status) {
                case CONCLUIDO -> {
                    return new ConcluidoState();
                }
                case CANCELADO -> {
                    return new CanceladoState();
                }
                default -> {
                    return new PendenteState();
                }
            }
        }
    }
}

