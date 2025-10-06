package org.purpura.apipg.util.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.HashMap;
import java.util.Map;

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
}