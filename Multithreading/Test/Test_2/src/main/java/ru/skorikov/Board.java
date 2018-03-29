package ru.skorikov;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 05.03.18
 * @ version: java_kurs_standart
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
}
