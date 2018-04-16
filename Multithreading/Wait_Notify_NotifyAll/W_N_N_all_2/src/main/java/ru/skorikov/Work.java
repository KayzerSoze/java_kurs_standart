package ru.skorikov;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
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
            Thread.sleep(1);
        } catch (InterruptedException e) {
            //Не знаю - можно так- нет? - вместо печати стектрейса остановить поток
            //e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        j.incrementAndGet();
        System.out.println("It's work " + j);
    }
}
