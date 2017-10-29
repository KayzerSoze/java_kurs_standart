package ru.skorikov;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 29.10.17
 * @ version: java_kurs_standart
 */
public class NodeTest {

    /**
     * Проверим Цикличный контейнер.
     * @throws Exception исключение.
     */
    @Test
    public void isContaynerCycle() throws Exception {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        Assert.assertFalse(Node.hasCycle(first));

    }

    /**
     * Проверим Нецикличный контейнер.
     * @throws Exception исключение.
     */
    @Test
    public void isContaynerNoCycle() throws Exception {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;

        Assert.assertTrue(Node.hasCycle(first));
    }

}