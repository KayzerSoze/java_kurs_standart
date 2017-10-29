package ru.skorikov;


/**
 * Created with IntelliJ IDEA.
 *
 * @param <T> параметр.
 * @ author: Alex_Skorikov.
 * @ date: 27.10.17
 * @ version: java_kurs_standart
 */
public class SimpleStack<T> {

    /**
     * Контейнер элементов.
     */
    SimpleLinkedContainer container = new SimpleLinkedContainer();

    /**
     * Добавить элемент в контейнер.
     *
     * @param value
     */
    public void push(T value) {
        container.add(value);
    }

    /**
     * Получить првый элемент и удалить его.
     * Первый добавленный элемент будет удален последним.
     *
     * @return первый элемент.
     */
    public T poll() {
        SimpleLinkedContainer.Element<T> returnElement = container.elementLast;

        SimpleLinkedContainer.Element<T> newLast = container.elementFirst;
        while (newLast.next.next != null) {
            newLast = newLast.next;
        }
        newLast.next = null;
        container.elementLast = newLast;

        return returnElement.data;
    }
}
