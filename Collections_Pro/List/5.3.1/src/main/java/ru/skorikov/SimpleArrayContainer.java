package ru.skorikov;


import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 23.10.17
 * @ version: java_kurs_standart
 * @param <E> параметр класса.
 *
 * Создать динамический список на базе массива.
 */
public class SimpleArrayContainer<E> implements Iterable<E> {
    /**
     * Массив объектов.
     */
    private Object[] container;
    /**
     * Счетчик.
     */
    private int index = 0;

    /**
     * Конструктор.
     *
     * @param size начальный размер массива.
     */
    public SimpleArrayContainer(int size) {
        this.container = new Object[size];
    }

    /**
     * Добавить объект в массив.
     * Если начальный массив не вмещает новый элемент
     * создаем новый массив и котируем в него старый
     * старый массив приравниваем новому.
     *
     * @param value объект.
     */
    public void add(E value) {
        if (index < container.length) {
            container[index++] = value;
        } else {
            Object[] newContainer = new Object[container.length * 2];
            System.arraycopy(container, 0, newContainer, 0, container.length);
            container = newContainer;
            container[index++] = value;
        }


    }

    /**
     * Получить объект из массива.
     *
     * @param index индекс объекта.
     * @return объект.
     */
    E get(int index) {
        return (E) container[index];
    }

    /**
     * Итератор для перемещения по коллекции.
     *
     * @return итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return index < container.length;
            }

            @Override
            public E next() {
                return (E) container[index++];
            }
        };
    }

}
