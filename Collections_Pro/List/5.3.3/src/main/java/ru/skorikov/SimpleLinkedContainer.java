package ru.skorikov;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @param <E> параметр класса.
 *            5.3.2. Создать контейнер на базе связанного списка
 * @ author: Alex_Skorikov.
 * @ date: 23.10.17
 * @ version: java_kurs_standart
 */
public class SimpleLinkedContainer<E> implements Iterable<E> {

    /**
     * Счетчик.
     */
    public int index = 0;

    /**
     * Начальный элемент.
     */
    public Element elementFirst;

    /**
     * Конечный элемент.
     */
    public Element elementLast;

    /**
     * Класс Элемент со ссылкой.
     * из которого формируется коллекция.
     *
     * @param <E> параметр.
     */
    public static class Element<E> {
        E data;
        Element next = null;
        int index = 0;
    }

    /**
     * Добавить элемент в контейнер.
     *
     * @param value элемент
     */
    public void add(E value) {
        Element element = new Element();
        element.data = value;
        if (elementFirst == null) {
            elementFirst = element;
            elementLast = element;
        } else {
            elementLast.next = element;
            elementLast = element;
        }
        element.index = index++;
    }

    /**
     * Получить элемент из контейнера по индексу.
     *
     * @param index индекс.
     * @return элемент.
     */
    public E get(int index) {
        Element<E> search = null;
        Element getElement = elementFirst;
        while (getElement != null) {
            if (getElement.index == index) {
                search = getElement;
                break;
            } else {
                getElement = getElement.next;
            }
        }
        if (search != null) {
            return search.data;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Element<E> el1 = elementFirst;
            Element<E> el2 = el1;

            @Override
            public boolean hasNext() {
                return el2 != null;
            }

            @Override
            public E next() {
                el1 = el2;
                el2 = el2.next;
                return el1.data;
            }
        };
    }
}
