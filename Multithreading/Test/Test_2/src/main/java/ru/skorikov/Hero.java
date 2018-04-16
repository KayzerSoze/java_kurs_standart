package ru.skorikov;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
 */
public abstract class Hero implements Runnable {
    /**
     * Имя героя игры.
     */
    private final String name;

    /**
     * Поле для героя.
     */
    private final Board board;

    /**
     * Создетель героя.
     *
     * @param name  имя.
     * @param board поле.
     */
    Hero(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    /**
     * Пробуем занять начальную позицию.
     *
     * @return ячейку с координатами стартовой позиции.
     */
    Cell startPosition() {
        //стратовая ячейка
        Cell start = null;
        int boardSize = board.getBoard().length;
        Random random = new Random();
        boolean isCreate = false;
        //пока не получим лок ячейки доски
        while (!isCreate) {
            int x = random.nextInt(boardSize - 1);
            int y = random.nextInt(boardSize - 1);
            start = new Cell(x, y);
            //Пробуем лочить ячейку для следующего хода.
            try {
                if (board.lockCellForNextStep(start, 0)) {
                    start = new Cell(x, y);
                    isCreate = true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return start;
    }

    /**
     * Генерация новой клетки.
     *
     * @param cell стартовая ячейка.
     * @return новая ячейка.
     */
    public abstract Cell createNewCell(Cell cell);

    /**
     * Следующий шаг.
     *
     * @param position начальная позиция.
     * @return следующая позиция.
     * @throws InterruptedException исключение.
     */
    public abstract Cell nextStep(Cell position) throws InterruptedException;
}
