package ru.skorikov;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 05.03.18
 * @ version: java_kurs_standart
 */
public class BoardTest {
    /**
     * Создадим поле и трех героев.
     */
    @Test
    public void tryCreateBoard() {
        Start start = new Start(Start.Level.EASY);
        start.startGame();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        start.stopGame();
    }
}