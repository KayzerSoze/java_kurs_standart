package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 22.01.18
 * @ version: java_kurs_standart
 * Класс продюссер.
 *
 */
public class Producer extends Thread {
    /**
     * Очередь.
     */
    private BlockingQueue blockingQueue;

    /**
     * Конструктор.
     * @param blockingQueue очередь.
     */
    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /**
     * Метод который делает какую то полезную работу.
     * @return то что сделал.
     */
    private Object produce() {
        return Thread.currentThread().getName();
    }

    @Override
    public void run() {
        //Бесконечно пробуем добавить в очередь.
        while (true) {
            try {
                int start = blockingQueue.getSize();
                blockingQueue.add(produce());
                if (start < blockingQueue.getSize()) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
