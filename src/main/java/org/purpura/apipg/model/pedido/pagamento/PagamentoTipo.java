package org.purpura.apipg.model.pedido.pagamento;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.purpura.apipg.util.enums.GenericEnumConverter;
import org.purpura.apipg.util.enums.ValuedEnum;

public enum PagamentoTipo implements ValuedEnum<String> {
    PIX("pix"),
    OUTRO("outro");

    private final String value;

    PagamentoTipo(String value) { this.value = value; }


    @Override
    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static PagamentoTipo fromValue(String value) {
        return GenericEnumConverter.fromValue(PagamentoTipo.class, value);
    }

    public static class Converter extends GenericEnumConverter<PagamentoTipo, String> {
        public Converter() {
            super(PagamentoTipo.class);
        }
    }

}

