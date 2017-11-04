package ru.skorikov;


/**
 * Created with IntelliJ IDEA.
 *
 * @param <E> параметр класса.
 *            3. Реализовать коллекцию типа Set на базе хэш-таблицы
 * @ author: Alex_Skorikov.
 * @ date: 02.11.17
 * @ version: java_kurs_standart
 */
public class SimpleHashSet<E> {

    /**
     * Хранилище объектов.
     */
    private Object[] table;

    /**
     * Конструктор.
     * <p>
     * Новое хранилище размером 36.
     */
    public SimpleHashSet() {
        this.table = new Object[36];
    }

    /**
     * Получить хранилище объектов.
     *
     * @return хранилище.
     */
    public Object[] getTable() {
        return table;
    }

    /**
     * Генерация хэша объекта.
     *
     * @param data item data.
     * @return хэш.
     */
    public int hash(E data) {
        String str = data.toString();

        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (31 * hash + str.charAt(i)) % table.length;
        }
        return hash;
    }

    /**
     * Добавить элемент.
     *
     * @param data данные.
     * @return добавлен - true, нет - false.
     */
    public boolean add(E data) {
        boolean ifAdded;
        int dataHash = hash(data);
        if (table[dataHash] == null) {
            ifAdded = true;
            table[dataHash] = data;
        } else {
            ifAdded = false;
        }
        return ifAdded;
    }

    /**
     * Содержит ли хранилище элемент.
     *
     * @param data данные
     * @return содержит - true, нет - false.
     */
    public boolean contains(E data) {
        boolean ifContains;
        if (table[hash(data)] != null) {
            ifContains = true;
        } else {
            ifContains = false;
        }
        return ifContains;
    }

    /**
     * Удалить элемент.
     *
     * @param data элемент.
     * @return true - удален, false - неудален.
     */
    public boolean remove(E data) {
        boolean ifRemove;
        if (table[hash(data)] != null) {
            table[hash(data)] = null;
            ifRemove = true;
        } else {
            ifRemove = false;
        }
        return ifRemove;
    }
}
