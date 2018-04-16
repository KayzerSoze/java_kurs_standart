package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
 */
public class Bomberman extends Hero {

    /**
     * Доска для бомбера.
     */
    private final Board board;

    /**
     * Имя.
     */
    private final String name;

    /**
     * Создетель Бомбермена.
     *
     * @param name  имя.
     * @param board поле.
     */
    Bomberman(String name, Board board) {
        super(name, board);
        this.board = board;
        this.name = name;
    }

    /**
     * Пользовательский ввод.
     *
     * @return от 0 до 3.
     */
    private int userAction() {
        return 5;
    }

    /**
     * Генерация новой ячейки.
     * из того что ввел пользователь.
     *
     * @param cell стартовая ячейка.
     * @return новая ячейка.
     */
    @Override
    public Cell createNewCell(Cell cell) {
        //Ячейка куда пойдем
        int nextCell = userAction();
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
     *
     * @param position стартовая позиция
     * @return новая позиция.
     */
    @Override
    public Cell nextStep(Cell position) throws InterruptedException {
        Cell next = createNewCell(position);
        //если не вышли за нраницы поля
        if (next.getX() >= 0 && next.getX() < board.getBoard().length - 1
                && next.getY() >= 0 && next.getY() < board.getBoard().length - 1) {
            //Пробуем завхватить лок в течении 0.5 сек
            if (board.lockCellForNextStep(next, 500)) {
                //Разлочим старую позицию
                board.unlockPreviousStep(position);
            }
        }
        return next;
    }

    /**
     * Тут Бомбер будет двигаться.
     */
    @Override
    public void run() {
        Thread.currentThread().setName(name);
        //Получаем позицию
        Cell startPosition = startPosition();
        //пока не прервали.
        while (!Thread.currentThread().isInterrupted()) {
            try {
                startPosition = nextStep(startPosition);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(Thread.currentThread().getName());
            System.out.println(" Cell " + startPosition.getX() + startPosition.getY());
        }
        System.out.println("Bomberman is Dead");
    }
}
