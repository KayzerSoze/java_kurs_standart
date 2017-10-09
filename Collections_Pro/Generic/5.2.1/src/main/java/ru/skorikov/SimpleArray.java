package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 09.10.17
 * @ version: java_kurs_standart
 * 5.2.1. Реализовать SimpleArray<T>.
 * Параметризованный класс.
 * @param <T> Параметр.
 */
public class SimpleArray<T> {

    /**
     * Поле массив объектов.
     */
    private Object[] objects;

    /**
     * Поле - счетчик.
     */
    private int index = 0;

    /**
     * Конструктор.
     *
     * @param size размер массива объектов.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Добавить элемент в массив.
     *
     * @param value элемент.
     */
    public void add(T value) {
        this.objects[index++] = value;
    }

    /**
     * Получить элемент массива.
     *
     * @param position позиция элемента.
     * @return элемент.
     */
    public T get(int position) {
        return (T) this.objects[position];
    }

    /**
     * Обновить элемент в массиве.
     *
     * @param index индекс в массиве.
     * @param value элемент.
     */
    public void update(int index, T value) {
        objects[index] = value;
    }

    /**
     * Удалить элемент.
     *
     * @param value элемент.
     */
    public void delete(T value) {
        for (int i = 0; i < objects.length - 1; i++) {
            if (objects[i] != null && objects[i].equals(value)) {
                objects[i] = null;
                System.arraycopy(this.objects, i + 1,
                        this.objects, i, this.objects.length - 1 - i);
            }
        }
    }
}
