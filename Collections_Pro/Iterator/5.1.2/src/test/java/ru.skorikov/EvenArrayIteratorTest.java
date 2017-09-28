package ru.skorikov;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 27.09.17
 * @ version: java_kurs_standart
 * 5.1.2. Создать итератор четные числа.
 * Тестовый класс.
 */
public class EvenArrayIteratorTest {
    /**
     * Проверим доступность элемента.
     * @throws Exception возможно исключение.
     */
    @Test
    public void whenGetNextElement() throws Exception {
        int[] nub = new int[] {4, 2, 1, 1, 2, 3, 2, 2};
        EvenArrayIterator iterator = new EvenArrayIterator(nub);

        iterator.next();
        int result = (int) iterator.next();

        Assert.assertTrue(result == 2);
    }

    /**
     * Проверим недоступность элемента массива.
     * @throws Exception возможно исключение.
     */
    @Test
    public void whetGetElementFromArray() throws Exception {
        int[] nub = new int[] {4, 2, 1, 1};
        EvenArrayIterator iterator = new EvenArrayIterator(nub);

        iterator.next();
        iterator.next();
        iterator.hasNext();
        boolean result = iterator.hasNext();

        Assert.assertThat(result, is(false));
    }

}