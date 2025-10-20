package org.purpura.apipg.util.enums;

/**
 * Essa interface tem a função de padronizar enums que possuem um valor associado às suas variantes.
 * @param <T>
 */
public interface ValuedEnum<T> {
    T getValue();
}