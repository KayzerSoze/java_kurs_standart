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
    @GuardedBy("itself")
    private List<Object> queue = new LinkedList();
    /**
     * Размер очереди.
     */
    @GuardedBy("itself")
    private int limit;

    /**
     * Конструктор.
     *
     * @param limit размер.
     */
    BlockingQueue(int limit) {
        this.limit = limit;
    }

    /**
     * Метод добавляет в очередь.
     *
     * @param item то что добавляем.
     * @throws InterruptedException исключение.
     */
    public synchronized void add(Object item) throws InterruptedException {
        //Пока лист заполнен (list.size == limit) добавлять не можем.
        while (this.queue.size() == this.limit) {
            //спим
            wait();
        }
        //можем добавить в конец листа.
        this.queue.add(item);
        //пробудить всех
        this.notifyAll();
    }

    /**
     * Метод получает из очереди.
     *
     * @return то что получаем.
     * @throws InterruptedException исключение.
     */
    public synchronized Object take() throws InterruptedException {
        //пока брать нечего
        while (this.queue.size() == 0) {
            //спим
            wait();
        }
        //получаем первое что-то из листа
        Object rezult = this.queue.get(0);
        //удаляем первый элемент - освобождаем 1 элемент в листе
        this.queue.remove(0);
        //будим всех
        this.notifyAll();
        //возвращаем данные.
        return rezult;
    }
}
