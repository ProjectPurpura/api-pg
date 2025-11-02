package org.purpura.apipg.util.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.HashMap;
import java.util.Map;

/**
 * Conversor genérico do JPA de instâncias de uma enum para seus valores correspondentes no banco de dados e vice-versa.
 * Utiliza da interface {@link ValuedEnum} para definir os valores de cada enum.
 * @param <E> Tipo da enum
 * @param <T> Tipo do valor da enum
 */
@Converter(autoApply = true)
public abstract class GenericEnumConverter<E extends Enum<E> & ValuedEnum<T>, T>
        implements AttributeConverter<E, T> {

    private final Map<T, E> valueToEnum = new HashMap<>();

    protected GenericEnumConverter(Class<E> enumClass) {
        for (E e : enumClass.getEnumConstants()) {
            valueToEnum.put(e.getValue(), e);
        }
    }

    @Override
    public T convertToDatabaseColumn(E attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public E convertToEntityAttribute(T dbData) {
        return dbData != null ? valueToEnum.get(dbData) : null;
    }

    public static <U extends Enum<U> & ValuedEnum<T>, T> U fromValue(Class<U> enumClass, T value) {
        for (U e : enumClass.getEnumConstants()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        return null;
    }
}