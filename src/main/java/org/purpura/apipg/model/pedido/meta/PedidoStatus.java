package org.purpura.apipg.model.pedido.meta;

import jakarta.persistence.Converter;
import org.purpura.apipg.util.enums.DbValuedEnum;
import org.purpura.apipg.util.enums.GenericEnumConverter;

public enum PedidoStatus implements DbValuedEnum<String> {
    PENDENTE("pendente"),
    APROVADO("aprovado"),
    CONCLUIDO("concluído"),
    CANCELADO("cancelado");

    private final String value;

    PedidoStatus(String value) {
        this.value = value;
    }

    @Override
    public String getDbValue() {
        return value;
    }

    @Converter(autoApply = true)
    public static class Convert extends GenericEnumConverter<PedidoStatus, String> {
        public Convert() {
            super(PedidoStatus.class);
        }
    }
}
