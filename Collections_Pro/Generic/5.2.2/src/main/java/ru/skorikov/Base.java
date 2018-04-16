package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
 */
public abstract class Base {
    /**
     * Поле класса Id.
     */
    private String id;

    /**
     * Констуктор.
     *
     * @param id поле класса.
     */

    public Base(String id) {
        this.id = id;
    }

    /**
     * Получить Id.
     *
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * Задать Id.
     *
     * @param id id.
     */
    public void setId(String id) {
        this.id = id;
    }

}
