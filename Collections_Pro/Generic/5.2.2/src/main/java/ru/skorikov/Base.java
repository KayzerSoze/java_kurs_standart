package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 09.10.17
 * @ version: java_kurs_standart
 * Абстрактынй класс Base.
 */
public abstract class Base {
    /**
     * Поле класса Id.
     */
    public String id;

    /**
     * Констуктор.
     *
     * @param id
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
