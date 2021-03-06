package ru.skorikov;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
 */
public class Board {

    /**
     * Игровое поле для монстров и героя.
     */
    private final ReentrantLock[][] board;

    /**
     * Создатель поля.
     *
     * @param boardSize размер (для простоты - квадратный).
     */
    Board(int boardSize) {
        board = new ReentrantLock[boardSize][boardSize];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    /**
     * Получить поле (для героя).
     *
     * @return поле.
     */
    public ReentrantLock[][] getBoard() {
        return board;
    }

    /**
     * Локируем ячейку cell доски в течении времени time.
     * @param cell ячейка
     * @param time время
     * @return локировали или нет
     * @throws InterruptedException exception
     */
    public boolean lockCellForNextStep(Cell cell, long time) throws InterruptedException {
        return this.board[cell.getX()][cell.getY()].tryLock(time, TimeUnit.NANOSECONDS);
    }

    /**
     * Освободим ячейку на которой стояли.
     * @param cell ячейка.
     */
    public void unlockPreviousStep(Cell cell) {
        this.board[cell.getX()][cell.getY()].unlock();
    }
}
