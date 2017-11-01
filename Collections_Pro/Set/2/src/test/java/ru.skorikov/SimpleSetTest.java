package ru.skorikov;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;


/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 01.11.17
 * @ version: java_kurs_standart
 */
public class SimpleSetTest {
    /**
     * Для теста исключений.
     */
    @Rule
    public ExpectedException testException = ExpectedException.none();

    /**
     * Пробуем добавить дубликат и получить его.
     *
     * @throws Exception исключение.
     */
    @Test
    public void tryGetNoSuchElement() throws Exception {
        testException.expect(NoSuchElementException.class);
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(1);

        simpleSet.next();
        simpleSet.next();
        simpleSet.next();
    }

    /**
     * Пробуем добавить пять элементов, три разных и получить третий.
     *
     * @throws Exception исключение.
     */
    @Test
    public void thenAddFiveElementWhenReturnThree() throws Exception {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("String1");
        simpleSet.add("String2");
        simpleSet.add("String1");
        simpleSet.add("String2");
        simpleSet.add("String3");

        simpleSet.next();
        simpleSet.next();

        Assert.assertEquals(simpleSet.next(), "String3");
    }

}