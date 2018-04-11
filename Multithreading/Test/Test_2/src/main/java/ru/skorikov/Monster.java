package ru.skorikov;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 05.03.18
 * @ version: java_kurs_standart
 * <p>
 * Класс монстр расширяющий Hero.
 */
public class Monster extends Hero {

    /**
     * Для генерации случайной ячейки.
     */
    private final Random random = new Random();

    /**
     * Доска для монстров.
     */
    private final Board board;

    /**
     * Имя монстра.
     */
    private final String name;

    /**
     * Создатель монстра.
     *
     * @param name  имя.
     * @param board поле.
     */
    Monster(String name, Board board) {
        super(name, board);
        this.board = board;
        this.name = name;
    }

    /**
     * Генерация новой ячейки для монстра.
     *
     * @param cell стартовая ячейка.
     * @return новая ячейка.
     */
    @Override
    public Cell createNewCell(Cell cell) {
        //Cell randomCell = null;
        //случайное число от 0 до 4
        int nextCell = random.nextInt(5 - 1);
        int tempX = cell.getX();
        int tempY = cell.getY();
        switch (nextCell) {
            //клетка вверх
            case 0:
                tempX -= 1;
                break;
            //клетка вправо
            case 1:
                tempY += 1;
                break;
            //клетка вниз
            case 2:
                tempX += 1;
                break;
            //клетка влево
            case 3:
                tempY -= 1;
                break;
            default:
                break;
        }
        return new Cell(tempX, tempY);
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
    public Cell nextStep(Cell position) throws InterruptedException {
        boolean isNext = false;
        Cell next = null;
        //пока не найдем куда ходить
        while (!isNext) {
            next = createNewCell(position);
            //если не вышли за нраницы поля
            if (next.getX() >= 0 && next.getX() < board.getBoard().length - 1
                    && next.getY() >= 0 && next.getY() < board.getBoard().length - 1) {
                //Пробуем захватить лок в течении 0.5 сек
                if (board.lockCellForNextStep(next, 500)) {
                    //Разлочим старую позицию
                    board.unlockPreviousStep(position);
                    isNext = true;
                }
            }
        }
        return next;
    }

    /**
     * Тут монстр будет двигаться.
     * Каждую секунду на новую клетку.
     */
    @Override
    public synchronized void run() {
        Thread.currentThread().setName(name);
        //Получаем позицию
        Cell startPosition = startPosition();
        //пока не прервали.
        //спим секунду
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(1000);
                startPosition = nextStep(startPosition);
                System.out.print(Thread.currentThread().getName());
                System.out.println(" Cell " + startPosition.getX() + startPosition.getY());
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " отмучился");
            Thread.currentThread().interrupt();
        }
    }
}
