package org.purpura.apipg.util.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.HashMap;
import java.util.Map;

@Converter(autoApply = true)
public abstract class GenericEnumConverter<E extends Enum<E> & DbValuedEnum<T>, T>
        implements AttributeConverter<E, T> {

    private final Map<T, E> valueToEnum = new HashMap<>();
    private final Class<E> enumClass;

    protected GenericEnumConverter(Class<E> enumClass) {
        this.enumClass = enumClass;
        for (E e : enumClass.getEnumConstants()) {
            valueToEnum.put(e.getDbValue(), e);
        }
    }

    @Override
    public T convertToDatabaseColumn(E attribute) {
        return attribute != null ? attribute.getDbValue() : null;
    }

    @Override
    public E convertToEntityAttribute(T dbData) {
        return dbData != null ? valueToEnum.get(dbData) : null;
    }
}