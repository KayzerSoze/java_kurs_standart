package ru.skorikov;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @param <E> параметр класса.
 *            <p>
 *            Реализовать коллекцию Set на массиве
 * @ author: Alex_Skorikov.
 * @ date: 01.11.17
 * @ version: java_kurs_standart
 */
public class SimpleSet<E> implements Iterator<E> {
    /**
     * Хранилище объектов.
     */
    private Object[] simpleSet;
    /**
     * Номер в хранилище.
     */
    private int index;
    /**
     * Переменная итератора.
     */
    private int iteratorIndex = 0;

    /**
     * Конструктор.
     *
     * @param size начальный размер хранилища.
     */
    public SimpleSet(int size) {
        this.simpleSet = new Object[size];
    }

    /**
     * Добавить объект в хранилище.
     *
     * @param data объект.
     */
    public void add(E data) {
        // Есть ли такой объект.
        boolean isDublicate = false;
        for (int i = 0; i < simpleSet.length;) {
            if (data.equals(simpleSet[i])) {
                isDublicate = true;
                break;
            } else {
                i++;
            }
        }
        if (!isDublicate) {
            // Хватает ли места в массиве.
            if (index <= simpleSet.length) {
                simpleSet[index] = data;
                index++;
            } else {
                simpleSet = Arrays.copyOf(simpleSet, simpleSet.length * 2);
                simpleSet[index] = data;
                index++;
            }
        }
    }

    @Override
    public boolean hasNext() {
        boolean isNext = false;
        if (iteratorIndex < simpleSet.length && simpleSet[iteratorIndex] != null) {
            isNext = true;
        }
        return isNext;
    }

    @Override
    public E next() {
        return (E) simpleSet[iteratorIndex++];
    }

    /**
     * Получить коллекцию.
     *
     * @return коллекция.
     */
    public Object[] getSimpleSet() {
        return simpleSet;
    }

    /**
     * Получить индекс.
     *
     * @return индекс.
     */
    public int getIndex() {
        return index;
    }
}
