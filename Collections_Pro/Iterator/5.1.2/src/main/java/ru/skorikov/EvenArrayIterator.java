package ru.skorikov;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 27.09.17
 * @ version: java_kurs_standart
 * 5.1.2. Создать итератор четные числа.
 */
public class EvenArrayIterator implements Iterator {
    /**
     * Массив элементов.
     */
    private final int[] array;
    /**
     * Счетчик итерации.
     */
    private int index = 0;

    /**
     * Конструктор.
     *
     * @param array массив.
     */
    public EvenArrayIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean isNext = false;
        for (int i = index; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                isNext = true;
                break;
            }
        }
        return isNext;
    }

    @Override
    public Object next() {
        for (int i = index; i < array.length;) {
            if (array[i] % 2 == 0) {
                index = i;
                break;
            } else {
                i++;
            }
        }
        return array[index++];
    }

}
