package ru.skorikov;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @param <K> key.
 * @param <V> value.
 * @ author: Alex_Skorikov.
 * @ date: 08.11.17
 * @ version: java_kurs_standart
 * 8. Реализовать собственную структуру данных - справочник.
 */
public class Directory<K, V> implements Iterator {
    /**
     * Store items.
     */
    private Object[] directory;

    /**
     * Designer.
     */
    public Directory() {
        this.directory = new Object[32];
    }

    /**
     * Iterator index.
     */
    private int index = 0;

    /**
     * Return Iteratir element.
     */
    private Element returnElement;

    /**
     * Generate hash.
     *
     * @param data object
     * @return hash-code
     */
    private int hash(Object data) {
        int hash;
        if (data != null) {
            hash = Math.abs(data.hashCode() % directory.length);
        } else {
            hash = 0;
        }
        return hash;
    }

    @Override
    public boolean hasNext() {
        return index < directory.length;
    }

    @Override
    public Object next() {
        while (hasNext()) {
            if (directory[index] == null) {
                index++;
            } else {
                returnElement = (Element) directory[index];
                index++;
                break;
            }
        }
        return returnElement;
    }

    /**
     * Inner class.
     */
    class Element {
        /**
         * Element key.
         */
        private K key;
        /**
         * Element value.
         */
        private V value;

        /**
         * Designer.
         *
         * @param key   element key
         * @param value element value
         */
        private Element(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Add item to store.
     *
     * @param key   item key.
     * @param value item value.
     * @return isAdded
     */
    public boolean insert(K key, V value) {
        boolean isAdded;
        if (directory[hash(key)] == null) {
            isAdded = true;
            directory[hash(key)] = new Element(key, value);
        } else {
            isAdded = false;
        }
        return isAdded;
    }

    /**
     * Receive an item by key.
     *
     * @param key item key
     * @return item value.
     */
    public V get(K key) {
        if (directory[hash(key)] != null) {
            Element element = (Element) directory[hash(key)];
            return element.value;
        } else {
            throw new NoSuchElementException("No element");
        }
    }

    /**
     * Delete item by key.
     *
     * @param key item key.
     * @return isDelete.
     */
    public boolean delete(K key) {
        boolean isDelete;
        if (directory[hash(key)] != null) {
            isDelete = true;
            directory[hash(key)] = null;
        } else {
            isDelete = false;
        }
        return isDelete;
    }
}
