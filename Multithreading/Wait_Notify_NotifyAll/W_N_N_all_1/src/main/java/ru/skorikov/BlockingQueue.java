package ru.skorikov;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 21.01.18
 * @ version: java_kurs_standart
 */
@ThreadSafe
public class BlockingQueue {
    /**
     * Лист - очередь.
     */
    @GuardedBy("this")
    private List queue = new LinkedList();
    /**
     * Размер очереди.
     */
    @GuardedBy("this")
    private int limit;

    /**
     * Конструктор.
     * @param limit размер.
     */
    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    /**
     * Получить размер очереди.
     * @return размер.
     */
    public int getSize() {
        return queue.size();
    }

    /**
     * Метод добавляет в очередь.
     * @param item то что добавляем.
     * @throws InterruptedException исключение.
     */
    public synchronized void add(Object item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }

    /**
     * Метод получает из очереди.
     * @return то что получаем.
     * @throws InterruptedException исключение.
     */
    public synchronized Object take() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        Object item = this.queue.get(0);
        this.queue.remove(0);
        return item;
    }
}
