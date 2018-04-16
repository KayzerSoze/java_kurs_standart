package ru.skorikov;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: AlexSkorikov.
 * @version: java_kurs_standart
 */
public class ArrayIterator implements Iterator {

    /**
     * Двумерный массив.
     */
    private int[][] value;

    /**
     * Переменная для получения следующего элемента.
     */
    private int iter = 0;

    /**
     * Переменная для итерации по строкам массива.
     */
    private int index = 0;

    /**
     * Переменная для итерации по столбцам массива.
     */
    private int jindex = 0;

    /**
     * Конструктор.
     * @param value массив.
     */
    public ArrayIterator(int[][] value) {
        this.value = value;
    }
    //Работает при условии симметрии массива.
    @Override
    public boolean hasNext() {
        return iter < value.length * value[0].length;
    }

    @Override
    public Object next() {

        int num = value[index][jindex];

        if (jindex < value[index].length - 1) {
            jindex++;
        } else {
            index++;
            jindex = 0;
        }
        iter++;
        return num;
    }

}
