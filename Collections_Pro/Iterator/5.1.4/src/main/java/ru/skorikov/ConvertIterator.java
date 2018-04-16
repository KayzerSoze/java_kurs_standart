package ru.skorikov;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
 *
 */
public class ConvertIterator {

    /**
     * Метод проходит по итераторам.
     * без копирования данных.
     *
     * @param allIterator итератор итераторов.
     * @return общий итератор.
     */
    static Iterator<Integer> convert(Iterator<Iterator<Integer>> allIterator) {

        return new Iterator<Integer>() {
            private Iterator currentIterator = allIterator.next();

            @Override
            public boolean hasNext() {
                boolean isNext = false;

                if (allIterator.hasNext() || currentIterator.hasNext()) {
                    isNext = true;
                }

                return isNext;
            }

            @Override
            public Integer next() {
                int mun = 0;
                if (currentIterator.hasNext()) {
                    mun = (int) currentIterator.next();
                } else {
                    currentIterator = allIterator.next();
                    mun = (int) currentIterator.next();
                }
                return mun;
            }
        };
    }
}
