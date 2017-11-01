package ru.skorikov;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 01.11.17
 * @ version: java_kurs_standart
 */
public class SimpleSetTest {

    /**
     * Создадим новый контейнер.
     * Добавим 3 одинаковых объекта.
     * В коллекции должен быть один - index равен 1.
     * @throws Exception исключение.
     */
    @Test
    public void thenAddThreeEqualsObjectWhenReturnOne() throws Exception {
        SimpleSet<String> simpleSet = new SimpleSet<>(5);
        simpleSet.add("string");
        simpleSet.add("string");
        simpleSet.add("string");

        assertThat(simpleSet.getIndex(), is(1));
    }
    /**
     * Создадим новый контейнер.
     * Добавим 3 разных объекта.
     * В коллекции должено быть три - index равен 3.
     * @throws Exception исключение.
     */
    @Test
    public void thenAddThreeDifferentObjectWhenReturnThree() throws Exception {
        SimpleSet<String> simpleSet = new SimpleSet<>(5);
        simpleSet.add("string");
        simpleSet.add("string1");
        simpleSet.add("string2");

        assertThat(simpleSet.getIndex(), is(3));
    }

}