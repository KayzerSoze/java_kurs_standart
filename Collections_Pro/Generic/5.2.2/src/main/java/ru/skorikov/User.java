package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
 */
public class User extends Base {

    /**
     * Поле имя.
     */
    private String name;

    /**
     * Конструктор.
     *
     * @param id   Id.
     * @param name имя.
     */
    public User(String id, String name) {
        super(id);
        this.name = name;
    }

    /**
     * Получить имя.
     *
     * @return имя объекта.
     */
    public String getName() {
        return name;
    }

    /**
     * Задать имя.
     *
     * @param name имя объекта.
     */
    public void setName(String name) {
        this.name = name;
    }

}
