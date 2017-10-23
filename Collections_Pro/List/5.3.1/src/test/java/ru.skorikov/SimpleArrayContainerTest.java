package ru.skorikov;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;


/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 23.10.17
 * @ version: java_kurs_standart
 */
public class SimpleArrayContainerTest {

    /**
     * Пробуем добавить объект.
     *
     * @throws Exception исключение.
     */
    @Test
    public void tryAddObjectStringToConteyner() throws Exception {
        SimpleArrayContainer<String> container = new SimpleArrayContainer<>(1);
        container.add("string1");
        container.add("string2");
        container.add("string3");

        Assert.assertThat(container.get(2), is("string3"));

    }

    /**
     * Пробуем получить объект типа String.
     *
     * @throws Exception исключение.
     */
    @Test
    public void tryGetObjectStringFromContainer() throws Exception {
        SimpleArrayContainer<String> container = new SimpleArrayContainer(2);
        container.add("name");
        container.add("name2");

        String str = container.get(1);

        Assert.assertThat(str, is("name2"));
    }

    /**
     * Пробуем получить объект типа Integer.
     *
     * @throws Exception исключение.
     */
    @Test
    public void tryGetObjecIntegertFromContainer() throws Exception {
        SimpleArrayContainer<Integer> container = new SimpleArrayContainer(2);
        container.add(25);
        container.add(35);

        Integer testInt = container.get(1);

        Assert.assertThat(testInt, is(35));
    }

}