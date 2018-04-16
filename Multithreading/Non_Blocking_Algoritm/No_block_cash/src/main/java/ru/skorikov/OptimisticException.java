package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
 */
public class OptimisticException extends Throwable {
    /**
     * Конструктор.
     */
    public OptimisticException() {
        super("Data was updated");
    }
}
