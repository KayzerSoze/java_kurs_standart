package ru.skorikov;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @param <E> параметр класса.
 *            Set реализованный на связном списке.
 * @ author: Alex_Skorikov.
 * @ date: 01.11.17
 * @ version: java_kurs_standart
 */
public class SimpleSet<E> implements Iterator<E> {

    /**
     * Первый элемент коллекции.
     */
    private Element firstElement;
    /**
     * Последний элемент коллекции.
     */
    private Element lastElement;

    /**
     * Элемент для итератора.
     */
    private Element iteratorElement;

    /**
     * Класс Элемент.
     *
     * @param <E> параметр.
     */

    private class Element<E> {
        /**
         * Данные элемента коллекции.
         */
        private E data;
        /**
         * Ссылка на следующий элемент коллекции.
         */
        private Element next;

        /**
         * Конструктор.
         *
         * @param data данные элемента коллекции.
         */
        public Element(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(E data) {
        //Если коллекция пустая
        if (firstElement == null) {
            firstElement = new Element(data);
            lastElement = firstElement;
            iteratorElement = firstElement;
        } else {
            // Ищем дубликат.
            Element<E> element = firstElement;
            boolean isAdd = false;
            while (element != null) {
                if (!data.equals(element.data)) {
                    element = element.next;
                } else {
                    isAdd = false;
                    break;
                }
                isAdd = true;
            }
            //Если дубликата нет.
            if (isAdd) {
                Element<E> eElement = new Element<>(data);
                lastElement.next = eElement;
                lastElement = eElement;
            }
        }
    }

    @Override
    public boolean hasNext() {
        if (firstElement != null) {
            return iteratorElement != null;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public E next() {
        Element<E> returnElement;
        if (firstElement == null || iteratorElement == null) {
            throw new NoSuchElementException();
        } else {
            returnElement = iteratorElement;
            iteratorElement = iteratorElement.next;
        }
        return returnElement.data;
    }

    public static void main(String[] args) {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("1");
        simpleSet.add("2");
        simpleSet.add("1");
        simpleSet.add("2");
        simpleSet.add("1");
        simpleSet.add("1");
        simpleSet.add("1");
        simpleSet.add("2");
        simpleSet.add("String3");

//        String str = simpleSet.next();
//        String str1 = simpleSet.next();
//        String str2 = simpleSet.next();

//        System.out.println(str);
//        System.out.println(str1);
//        System.out.println(str2);

        while (simpleSet.hasNext()){
            System.out.println(simpleSet.next());
        }

    }
}
