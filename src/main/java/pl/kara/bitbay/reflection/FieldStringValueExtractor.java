package pl.kara.bitbay.reflection;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
public final class FieldStringValueExtractor {

    public static ImmutableMap<String, String> fieldNamesWithValues(final Object fromObject) {
        final ImmutableMap.Builder<String, String> fieldNamesWithValuesMap = ImmutableMap.builder();
        final Stream<Field> declaredFields = Stream.of(fromObject.getClass().getDeclaredFields());

        declaredFields.peek(field -> field.setAccessible(true))
                .filter(FieldModifiers.NOT_STATIC_PRIVATE_FINAL)
                .map(field -> mapFieldToSimpleMapEntry(field, fromObject))
                .filter(FieldStringValueExtractor::valueIsNotNull)
                .map(FieldStringValueExtractor::makeValueToString)
                .forEach(fieldNamesWithValuesMap::put);

        return fieldNamesWithValuesMap.build();
    }

    private static AbstractMap.SimpleEntry<String, Object> mapFieldToSimpleMapEntry(final Field field, final Object object) {
        try {
            return new AbstractMap.SimpleEntry<>(field.getName(), field.get(object));
        } catch (IllegalAccessException e) {
            log.error("", e);
        }
        return new AbstractMap.SimpleEntry<>(null, null); //TODO REFACTOR moze istnieje lepszy sposob niz te nulle ?
    }

    private static boolean valueIsNotNull(final AbstractMap.SimpleEntry<String, Object> entry) {
        return Objects.nonNull(entry.getValue());
    }

    private static AbstractMap.SimpleEntry<String, String> makeValueToString(final AbstractMap.SimpleEntry<String, Object> entry) {
        return new AbstractMap.SimpleEntry<>(entry.getKey(), String.valueOf(entry.getValue()));
    }

}
