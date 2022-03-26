package de.exxcellent.challenge.parser.api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Skeleton realisation of parser, contains reusable method of instantiation from common Row class to needed class.
 * Uses reflection for instantiation.
 */
public abstract class AbstractParser implements Parser {

    public <T> Collection<T> readAndConvert(String filePath, Class<T> clazz) {
        return readData(filePath).stream().map(it -> getInstance(it, clazz)).collect(Collectors.toList());
    }

    <T> T getInstance(Row data, Class<T> clazz) {
        var fields = clazz.getDeclaredFields();
        T obj = null;
        try {
            obj = clazz.getDeclaredConstructor().newInstance();
            String columnName;
            for (Field field : fields) {
                if (field.getAnnotation(Column.class) != null) {
                    columnName = field.getAnnotation(Column.class).value();
                } else columnName = field.getName();
                String columnValue = data.getValue(columnName);
                field.setAccessible(true);
                field.set(obj, castTypes(field, columnValue));
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }

    private Object castTypes(Field field, String obj) {
        switch (field.getType().getSimpleName()) {
            case "Integer": return Integer.parseInt(obj);
            case "BigDecimal": return new BigDecimal(obj);
            default: return obj;
        }
    }
}

