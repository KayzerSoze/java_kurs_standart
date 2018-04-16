package ru.skorikov;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
 */
public class Cell extends ReentrantLock {
    /**
     * Координаты горизонтали.
     */
    private final int x;
    /**
     * Координаты вертикали.
     */
    private final int y;

    /**
     * Создатель ячейки.
     *
     * @param x координата по горизонтали.
     * @param y координата по вертикали.
     */
    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Получить координату x.
     *
     * @return x.
     */
    public int getX() {
        return x;
    }

    /**
     * Получить координату y.
     *
     * @return y.
     */
    public int getY() {
        return y;
    }

}
