package ru.skorikov;

import java.util.Iterator;

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

        public E getData() {
            return data;
        }
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
    public E get(int index) throws NullPointerException {
        Element search = null;
        Element getElement = elementFirst;
        try {
            while (getElement != null) {
                if (getElement.index == index) {
                    search = getElement;
                    break;
                } else {
                    getElement = getElement.next;
                }
            }
        } catch (Exception ex) {
            System.out.println("No elements");
        }
        return (E) search;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Element el1 = elementFirst;
            Element el2 = el1;

            @Override
            public boolean hasNext() {
                return el2 != null;
            }

            @Override
            public E next() {
                el1 = el2;
                el2 = el2.next;
                return (E) el1;
            }
        };
    }

    /**
     * Метод получает значение элементов в контейнере по индексу.
     *
     * @param index
     * @return element data.
     */
    public E getData(int index) {

        Element searchElenent = (Element) get(index);
        if (searchElenent != null) {
            return (E) searchElenent.data;
        } else {
            throw new NullPointerException("No element");
        }
    }
}
