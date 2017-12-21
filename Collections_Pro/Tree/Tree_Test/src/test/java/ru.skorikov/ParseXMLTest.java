package ru.skorikov;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Map;

import static org.hamcrest.core.Is.is;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 21.12.17
 * @ version: java_kurs_standart
 */
public class ParseXMLTest {
    /**
     * Проверим самодельный парсинг.
     * В результате должны получить карту с одной картой в которой один ордер.
     * "book-1","SELL","100.00","40".
     *
     * @throws Exception исключение.
     */
    @Test
    public void whenParseFileThenReturnArray() throws Exception {
        OrderBook orderBook = new OrderBook();
        File file = new File("test_book.xml");
        ParseXML parseXML = new ParseXML();
        orderBook.work(parseXML.parse(file));
        Map<String, Map<Integer, Order>> mapMap = parseXML.getBooks();

        Map<Integer, Order> map = mapMap.get("book-1");

        Assert.assertEquals(map.size(), 1);

        Order order = map.get(0);

        Assert.assertEquals(order.getOperation(), "SELL");
        Assert.assertEquals(order.getPrice(), 100, 00);
        Assert.assertThat(order.getVolume(), is(40));

    }

}