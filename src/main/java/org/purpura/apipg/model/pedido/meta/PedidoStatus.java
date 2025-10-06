package org.purpura.apipg.model.pedido.meta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Converter;
import org.purpura.apipg.util.enums.ValuedEnum;
import org.purpura.apipg.util.enums.GenericEnumConverter;

public enum PedidoStatus implements ValuedEnum<String> {
    PENDENTE("pendente"),
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
        for (PedidoStatus status : PedidoStatus.values()) {
            if (status.getValue().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status de pedido não conhecido: " + value);
    }

    @Converter(autoApply = true)
    public static class Convert extends GenericEnumConverter<PedidoStatus, String> {
        public Convert() {
            super(PedidoStatus.class);
        }
    }
}
