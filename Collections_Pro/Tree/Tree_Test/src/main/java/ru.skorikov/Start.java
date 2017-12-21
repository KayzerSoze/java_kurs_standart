package ru.skorikov;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 20.12.17
 * @ version: java_kurs_standart
 */
public class Start {
    /**
     * Входной файл.
     */
    private File file = new File("/home/insaider/test_book.xml");
    /**
     * Книга ордеров.
     */
    private OrderBook orderBook = new OrderBook();

    /**
     * Запуск приложения.
     *
     * @param args массив строк.
     * @throws IOException исключения.
     */
    public static void main(String[] args) throws IOException {
        //Время начала работы.
        Date dateStart = new Date();
        Start start = new Start();

        // Разбор файла.
//        ParseXML parseXML = new ParseXML();
//        start.orderBook.setBooks(parseXML.parse(start.file));
        // Разбор файла.
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXHandler handler = new SAXHandler();
            parser.parse(start.file, handler);
            start.orderBook.setBooks(handler.getBooks());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Сортировка и вывод
        start.orderBook.work(start.orderBook.getBooks());
        start.orderBook.printMap(start.orderBook.getBooks());

        //Время окончания работы.
        //используя ParseXML - 9 sec.
        //используя SAXHandler - 14 sec.
        Date end = new Date();
        long timeWork = (end.getTime() - dateStart.getTime());
        System.out.printf("Time work :  %s  ms (%s sek)", timeWork, timeWork / 1000);
    }
}
