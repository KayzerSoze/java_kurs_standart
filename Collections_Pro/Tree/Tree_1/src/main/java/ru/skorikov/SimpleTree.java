package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
 * @param <E> параметр.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return isAdded.
     */
    boolean add(E parent, E child);
}


