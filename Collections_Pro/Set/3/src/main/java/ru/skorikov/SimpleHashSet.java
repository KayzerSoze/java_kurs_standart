package ru.skorikov;


import com.sun.xml.internal.bind.v2.TODO;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 02.11.17
 * @ version: java_kurs_standart
 */
public class SimpleHashSet<E> {
    /**
     * Данные объекта.
     */
    private E data;
    /**
     * Хранилище объектов.
     * Новая хэш-таблица с начальным размером 10.
     */
    private SimpleHashTable table = new SimpleHashTable(21);

    public SimpleHashSet(SimpleHashTable table) {
        this.table = table;
    }

    /**
     * Генерация хэша объекта.
     *
     * @param data данные объекта.
     * @return хэш.
     */
    private int hash(E data) {
        String str = data.toString();
        int hash = 1;

        for (int i = 0; i < str.length(); i++)
            hash = (31 * hash + str.charAt(i)) % table.size;

        return hash;
    }

    public boolean add(E data) {
//        SimpleHashSet element = new SimpleHashSet();
        int hash = hash(data);
//        while(table[hash] != null)
//        {
//            hash++;
//            hash %= table.size;
//        }
//        table[hash] = element;

        return false;
    }

    public boolean contains(E data) {
        return false;
    }

    public boolean remove(E data) {
        return false;
    }

    static class SimpleHashTable {
        /**
         * Массив объктов.
         */
        private SimpleHashSet[] table;
        /**
         * Количество объектов в массиве.
         */
        private int count;
        /**
         * Размер масива.
         */
        private int size;

        /**
         * Конструктор.
         *
         * @param size размер массива.
         */
        public SimpleHashTable(int size) {
            this.size = size;
            this.table = new SimpleHashSet[size];
        }
    }

    public static void main(String[] args) {
        SimpleHashSet<String> set = new SimpleHashSet<>(new SimpleHashTable(10));
        int t = set.hash("strin33232323321lkjhlkjhljkhg");
        int r = set.hash("aaaaass");
        System.out.println(t);
        System.out.println(r);
        String tff = "aa";
        System.out.println(tff.hashCode());
    }

}
