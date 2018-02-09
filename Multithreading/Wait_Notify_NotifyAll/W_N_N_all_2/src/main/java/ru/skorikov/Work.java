package ru.skorikov;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 07.02.18
 * @ version:
 * Класс работа.
 */
public class Work implements Runnable {
    /**
     * Какая то полезная переменная.
     */
    private AtomicInteger j = new AtomicInteger();
    //Полезный метод.
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j.incrementAndGet();
        System.out.println("It's work " + j);
    }
}
