package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 28.03.18
 * @ version: java_kurs_standart
 */
public class Start {
    /**
     * Игровое поле.
     */
    private Board board;
    /**
     * Количество монстров.
     */
    private Thread[] monsters;
    /**
     * Бомбермен.
     */
    private Thread bomberman;

    /**
     * Уровни.
     */
    public enum Level {
        /**
         * Легко.
         */
        EASY,
        /**
         * Средне.
         */
        MEDIUM,
        /**
         * Сложно.
         */
        HEAVY
    }

    /**
     * @param level Уровень.
     */
    Start(Level level) {
        switch (level) {
            case EASY:
                board = new Board(10);
                generateLevel(this.board, easyLevel);
                monsters = new Thread[3];
                break;
            case MEDIUM:
                board = new Board(10);
                generateLevel(this.board, mediumLevel);
                monsters = new Thread[5];
                break;
            case HEAVY:
                board = new Board(10);
                generateLevel(this.board, heavyLevel);
                monsters = new Thread[7];
                break;
            default:
                break;
        }
        bomberman = new Thread(new Bomberman("Bombr", this.board));
    }

    /**
     * Массив блокируемых ячеек для легкого уровня.
     *  |0123456789
     * 0|          |
     * 1|      0   |
     * 2|  00  00  |
     * 3|  0       |
     * 4|    00  0 |
     * 5|  0  0  0 |
     * 6|  00      |
     * 7|      0   |
     * 8|     00   |
     * 9|__________|
     */
    private final int[][] easyLevel = {{1, 6}, {2, 2}, {2, 3}, {2, 6}, {2, 7}, {3, 2},
            {4, 4}, {4, 5}, {4, 8}, {5, 2}, {5, 5}, {5, 8}, {6, 2}, {6, 3}, {7, 6}, {8, 5}, {8, 6}};
    /**
     * Массил блокируемых ячеек для среднего уровня.
     *  |0123456789
     * 0|          |
     * 1| 000  000 |
     * 2| 0      0 |
     * 3| 0      0 |
     * 4|    00    |
     * 5|    00    |
     * 6| 0      0 |
     * 7| 0      0 |
     * 8| 000  000 |
     * 9|__________|
     */
    private final int[][] mediumLevel = {{1, 1}, {1, 2}, {1, 3}, {1, 6}, {1, 7}, {1, 8},
            {2, 1}, {2, 8}, {3, 1}, {3, 8}, {4, 4}, {4, 5}, {5, 4}, {5, 5}, {6, 1}, {6, 8}, {7, 1},
            {7, 8}, {8, 1}, {8, 2}, {8, 3}, {8, 6}, {8, 7}, {8, 8}};
    /**
     * Массив блокируемых ячеек для тяжелого уровня.
     *  |0123456789
     * 0| 0     0  |
     * 1|   000    |
     * 2| 00    0  |
     * 3|       00 |
     * 4| 000      |
     * 5| 0 0 000  |
     * 6| 0   0    |
     * 7|   0 00 0 |
     * 8| 000 0  0 |
     * 9|__________|
     */
    private final int[][] heavyLevel = {{0, 1}, {0, 7}, {1, 3}, {1, 4}, {1, 5}, {2, 1},
            {2, 2}, {2, 7}, {3, 7}, {3, 8}, {4, 1}, {4, 2}, {4, 3}, {5, 1}, {5, 3}, {5, 5}, {5, 6},
            {5, 7}, {6, 1}, {6, 5}, {7, 3}, {7, 5}, {7, 6}, {7, 8}, {8, 1}, {8, 2}, {8, 3}, {8, 5},
            {8, 8}};

    /**
     * Генерация уровня на карте из массива блокируемых ячеек.
     *
     * @param board игровое поле.
     * @param level масив блокируемых ячеек.
     */
    private void generateLevel(Board board, int[][] level) {
        for (int[] aLevel : level) {
            board.getBoard()[aLevel[0]][aLevel[1]].lock();
        }
    }

    /**
     * Запустить монстров и бомбермена по полю.
     */
    public void startGame() {
        bomberman.start();
        for (int i = 0; i < monsters.length; i++) {
            String name = "Monster_" + i;
            monsters[i] = new Thread(new Monster(name, board));
            monsters[i].start();
        }
    }

    /**
     * Прибить героев.
     */
    public void stopGame() {
        for (Thread heroe : monsters) {
            heroe.interrupt();
        }
        bomberman.interrupt();
    }
}
