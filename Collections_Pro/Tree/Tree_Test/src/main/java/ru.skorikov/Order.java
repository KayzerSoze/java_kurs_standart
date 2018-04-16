package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
 */
public class Order {
    /**
     * Операция.
     */
    private String operation;
    /**
     * Цена.
     */
    private Double price;
    /**
     * Объем.
     */
    private Integer volume;

    /**
     * Конструктор.
     *
     * @param operation операция.
     * @param price     цена.
     * @param volume    объем.
     */
    public Order(String operation, Double price, Integer volume) {
        this.operation = operation;
        this.price = price;
        this.volume = volume;
    }

    /**
     * Получить операцию.
     *
     * @return операция.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Получить цену.
     *
     * @return цена.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Получить объем.
     *
     * @return объем.
     */
    public Integer getVolume() {
        return volume;
    }
}
