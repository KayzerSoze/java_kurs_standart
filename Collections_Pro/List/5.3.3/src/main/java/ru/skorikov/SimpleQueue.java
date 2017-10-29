package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @param <T> параметр.
 * @ author: Alex_Skorikov.
 * @ date: 27.10.17
 * @ version: java_kurs_standart
 */
public class SimpleQueue<T> {

    /**
     * Контейнер на базе односвязного списка.
     */
    SimpleLinkedContainer container = new SimpleLinkedContainer();

    /**
     * Добавить объект в контейнер.
     *
     * @param value данные.
     */
    public void push(T value) {
        container.add(value);
    }

    /**
     * Метод возвращает последний элемент и удаляет его.
     * Первый добавленный элемент будет удален первым.
     *
     * @return последний элемент.
     */
    public T poll() {
        container.elementFirst = container.elementFirst.next;
        SimpleLinkedContainer.Element<T> element = container.elementFirst;

        while (element != null) {
            element.index--;
            element = element.next;
        }
        container.index--;

        SimpleLinkedContainer.Element<T> returnElement = container.elementFirst;

        return returnElement.data;
    }
}
