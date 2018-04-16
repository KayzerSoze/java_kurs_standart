package ru.skorikov;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
 */
@ThreadSafe
class Count {
    /**
     * Аннотация указывает на объект по которому будем синхронизироваться.
     * Синхронизация по полю value.
     */
    @GuardedBy("this")
    private int value;

    /**
     * Метод увеличивает счетчик на 1.
     */
    synchronized void increment() {
        this.value++;
    }

    /**
     * Вернуть счетчик.
     *
     * @return value
     */
    synchronized int get() {
        return this.value;
    }
}
