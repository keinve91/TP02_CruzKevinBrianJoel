package ar.edu.unju.fi.ejercicio06.interfaces.funcionales;

@FunctionalInterface
public interface Converter<T, R> {
    R convert(T t);

    default void mostrarObjeto(R r) {
        System.out.println("Objeto - " + r.toString());
    }

    static <T> boolean isNotNull(T t) {
        return t != null;
    }
}