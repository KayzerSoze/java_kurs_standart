package ru.skorikov;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
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
                index = i;
                break;
            }
        }
        return isNext;
    }

    @Override
    public Object next() {
        int returnInt = 0;
        if (hasNext()) {
            returnInt = array[index++];
        } else {
            throw new NoSuchElementException();
        }
        return returnInt;
    }

}
