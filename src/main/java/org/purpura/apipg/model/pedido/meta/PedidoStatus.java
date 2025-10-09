package org.purpura.apipg.model.pedido.meta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Converter;
import org.purpura.apipg.model.pedido.meta.state.*;
import org.purpura.apipg.util.enums.ValuedEnum;
import org.purpura.apipg.util.enums.GenericEnumConverter;

public enum PedidoStatus implements ValuedEnum<String> {
    ABERTO("aberto"),
    APROVADO("aprovado"),
    CONCLUIDO("concluído"),
    CANCELADO("cancelado");

    private final String value;

    PedidoStatus(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static PedidoStatus fromValue(String value) {
        return GenericEnumConverter.fromValue(PedidoStatus.class, value);
    }

    @Converter(autoApply = true)
    public static class Convert extends GenericEnumConverter<PedidoStatus, String> {
        public Convert() {
            super(PedidoStatus.class);
        }
    }

    public record Adapter(PedidoStatus status) {

        public PedidoState toState() {
            switch (this.status) {
                case APROVADO -> {
                    return new AprovadoState();
                }
                case CONCLUIDO -> {
                    return new ConcluidoState();
                }
                case CANCELADO -> {
                    return new CanceladoState();
                }
                default -> {
                    return new AbertoState();
                }
            }
        }
    }

}
