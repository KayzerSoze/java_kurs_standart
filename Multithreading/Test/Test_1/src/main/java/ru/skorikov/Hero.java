package ru.skorikov;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 05.03.18
 * @ version: java_kurs_standart
 */
public class Hero implements Runnable {
    /**
     * Имя героя.
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
    public Hero(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    /**
     *
     */
    private final Random random = new Random();

    /**
     * Пробуем занять начальную позицию.
     *
     * @return индексы начальной позиция.
     */
    private int[][] createPosition() {
        //Случайные числа для начальной позиции на доске.
        Random random = new Random();
        int boardSize = board.getBoard().length;
        int[][] position = new int[1][2];
        boolean isCreate = false;
        //Пробуем получть лок случайной ячейки доски.
        while (!isCreate) {
            int i = random.nextInt(boardSize - 1);
            int j = random.nextInt(boardSize - 1);
            if (board.getBoard()[i][j].tryLock()) {
                position[0][0] = i;
                position[0][1] = j;
                isCreate = true;
            }
        }
        return position;
    }

    /**
     * Генерация случайной клетки.
     *
     * @param x строка.
     * @param y столбец.
     * @return новая ячейка.
     */
    private int[][] createRandomCell(int x, int y) {
        int[][] randomCell = new int[1][2];
        //случайное число от 0 до 4
        int nextCell = random.nextInt(5 - 1);
        int tempX = x;
        int tempY = y;
        switch (nextCell) {
            //клетка вверх
            case 0:
                tempX = x - 1;
                tempY = y;
                break;

            //клетка вправо
            case 1:
                tempX = x;
                tempY = y + 1;
                break;

            //клетка вниз
            case 2:
                tempX = x + 1;
                tempY = y;
                break;

            //клетка влево
            case 3:
                tempX = x;
                tempY = y - 1;
                break;

            default:
                break;
        }
        randomCell[0][0] = tempX;
        randomCell[0][1] = tempY;
        return randomCell;
    }

    /**
     * Следующий шаг.
     * Будем получать случайную ячейку сверху, снизу, слева или справа
     * и проверять на выход за пределы массива.
     * Если не вышли за пределы - пробуем локировать, разлокировать старую
     * и вернуть координаты новой.
     *
     * @param position стартовая позиция
     * @return конечная позиция.
     * @throws InterruptedException исключение.
     */
    private int[][] nextStep(int[][] position) throws InterruptedException {
        boolean isNext = false;
        int[][] next = new int[1][2];
        //строка
        int x = position[0][0];
        //столбец
        int y = position[0][1];
        //пока не найдем куда ходить
        while (!isNext) {
            next = createRandomCell(x, y);
            //если не вышли за нраницы поля
            if (next[0][0] >= 0 && next[0][0] < board.getBoard().length - 1
                    && next[0][1] >= 0 && next[0][1] < board.getBoard().length - 1) {
                //если получилось захватить лок
                if (board.getBoard()[next[0][0]][next[0][1]].tryLock(500, TimeUnit.MILLISECONDS)) {
                    board.getBoard()[x][y].unlock();
                    isNext = true;
                }
            }
        }
        return next;
    }


    /**
     * Тут герой будет двигаться.
     * Каждую секунду на новую клетку.
     */
    @Override
    public synchronized void run() {
        Thread.currentThread().setName(name);
        //Получаем позицию
        int[][] startPosition = createPosition();
        //пока не прервали.
        //спим секунду
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(1000);
                startPosition = nextStep(startPosition);
                System.out.print(Thread.currentThread().getName());
                System.out.println(" Cell " + startPosition[0][0] + startPosition[0][1]);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " отмучился");
            Thread.currentThread().interrupt();
        }
    }

}
