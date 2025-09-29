package org.purpura.apipg.model.pedido;

public enum PedidoStatus {
    PENDENTE("pendente"),
    APROVADO("aprovado"),
    CONCLUIDO("concluído"),
    CANCELADO("cancelado");

    private final String value;

    PedidoStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
