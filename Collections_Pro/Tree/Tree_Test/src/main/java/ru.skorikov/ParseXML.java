package ru.skorikov;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 10.12.17
 * @ version: java_kurs_standart
 * Самописный парсер.
 */
public class ParseXML {
    /**
     * Разбираемый файл.
     */
    private File file;
    /**
     * Хранилище карты книг из книг.
     */
    private Map<String, Map<Integer, Order>> books = new TreeMap<>();

    /**
     * Получить книгу.
     *
     * @return книга.
     */
    public Map<String, Map<Integer, Order>> getBooks() {
        return books;
    }

    /**
     * Метод разбирающий файл.
     *
     * @param file файл.
     * @return карта.
     * @throws IOException исключение - нет файла.
     */
    public Map<String, Map<Integer, Order>> parse(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        String[] str;

        while ((line = reader.readLine()) != null) {
            if (line.charAt(1) == 'A') {
                str = parseString(line, 5);
                String book = str[0];
                String position = str[1];
                double price = Double.parseDouble(str[2]);
                int volume = Integer.parseInt(str[3]);
                int id = Integer.parseInt(str[4]);
                if (books.containsKey(book)) {
                    books.get(book).put(id, new Order(position, price, volume));
                } else {
                    Map<Integer, Order> map = new HashMap<>();
                    map.put(id, new Order(position, price, volume));
                    books.put(book, map);
                }
            } else {
                if (line.charAt(1) == 'D') {
                    str = parseString(line, 2);
                    String book = str[0];
                    int id = Integer.parseInt(str[1]);
                    books.get(book).remove(id);
                }
            }
        }
        return books;
    }

    /**
     * Подметод. Ищем части строки заключенныев кавычки и заполняем массив строк.
     *
     * @param line Разбираемая строка.
     * @param size размер массива.
     * @return массив.
     */
    private String[] parseString(String line, int size) {
        String[] str = new String[size];
        int strIndex = 0;
        for (int i = 10; i < line.length() - 2;) {
            if (line.charAt(i) != '\"') {
                i++;
            } else {
                for (int j = ++i; j < line.length() - 2;) {
                    if (line.charAt(j) != '\"') {
                        j++;
                    } else {
                        str[strIndex] = line.substring(i++, j--);
                        i = j + 7;
                        strIndex++;
                        break;
                    }
                }
            }
        }
        return str;
    }
}
