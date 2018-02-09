package ru.skorikov;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 08.02.18
 * @ version: java_kurs_standart
 */
public class ThreadPoolTest {
    /**
     * Создадим новый пул потоков.
     */
    @Test
    public void tryCreateNewThreadPool() {
        ThreadPool threadPool = new ThreadPool();
        threadPool.add(new Work());
        threadPool.add(new Work());
        threadPool.add(new Work());
    }
}