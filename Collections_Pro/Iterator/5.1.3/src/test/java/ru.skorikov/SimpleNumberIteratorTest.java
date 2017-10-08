package ru.skorikov;

import org.junit.Assert;
import org.junit.Test;



/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 28.09.17
 * @ version: java_kurs_standart
 * 5.1.3. Создать итератор простые числа.
 * Класс тест.
 */
public class SimpleNumberIteratorTest {
    /**
     * Проверим наличие простого числа в массиве.
     */
    @Test
    public void whenSimpleNumberInArray() {
        int[] num = new int[]{1, 4, 13};
        SimpleNumberIterator itr = new SimpleNumberIterator(num);

        int test = (int) itr.next();

        Assert.assertEquals(test, 13);
    }

    /**
     * Проверим отсутствие простого числа в массиве.
     */
    @Test
    public void whenSimpleNumberOutArray() {
        int[] num = new int[]{1, 4, 6};
        SimpleNumberIterator itr = new SimpleNumberIterator(num);

        boolean test = itr.hasNext();

        Assert.assertFalse(test);
    }

}