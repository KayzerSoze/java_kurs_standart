package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
 * @param <T> Параметр.
 */
public interface Store<T extends Base> {

    /**
     * Добавить объект.
     *
     * @param model объект.
     * @return объект.
     */
    T add(T model);

    /**
     * Обновить объект.
     *
     * @param model объект.
     * @return объект.
     */
    T update(T model);

    /**
     * Удалить объект.
     *
     * @param id Id объекта.
     * @return выполнена ли операция.
     */
    boolean delete(String id);
}
