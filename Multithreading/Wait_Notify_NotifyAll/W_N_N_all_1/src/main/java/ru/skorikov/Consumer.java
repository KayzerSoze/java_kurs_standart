package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 22.01.18
 * @ version: java_kurs_standart
 * Класс потребитель.
 */
public class Consumer extends Thread {
    /**
     * Очередь.
     */
    private BlockingQueue blockingQueue;
    /**
     * Что то полезное в очереди.
     */
    private Object data;

    /**
     * Конструктор.
     * @param blockingQueue очередь.
     */
    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /**
     * Получить нечто полезное.
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * Метод забирающий что то из очереди.
     */
    private void custom() {
        try {
            data = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        //пробуем получить что то из очереди.
        while (true) {
            int start = blockingQueue.getSize();
            custom();
            if (start > blockingQueue.getSize()) {
                break;
            }
        }
    }
}
