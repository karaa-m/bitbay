package pl.kara.bitbay.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.Predicate;

final class FieldModifiers {

    static final Predicate<Field> NOT_STATIC_PRIVATE_FINAL = field ->
            Modifier.isPrivate(field.getModifiers()) &&
                    Modifier.isFinal(field.getModifiers()) &&
                    !Modifier.isStatic(field.getModifiers());

}
