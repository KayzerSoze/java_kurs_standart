package ru.skorikov;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 19.12.17
 * @ version: java_kurs_standart
 *
 * Состоят ли слова из одинаковых букв.
 */
public class TwoWords {
    /**
     * Множество set - не хранит дубликаты.
     */
    private Set set = new HashSet();

    /**
     * Проверяем два слова.
     * Логика такая - заполняем set буквами более длинного слова.
     * записываем размер множества.
     * потом записываем в set буквы короткого слова.
     * если в слове есть новая буква - размер множества увеличится.
     *
     * @param str1 слово 1.
     * @param str2 слово 2.
     * @return true - состоят из одинаковых букв.
     */
    public boolean isWordsConsistOfIdenticalLetters(String str1, String str2) {
        boolean isWCOIL = false;

        if (str1.length() >= str2.length()) {
            for (char c : str1.toCharArray()) {
                set.add(c);
            }
            int setSize = set.size();
            for (char c : str2.toCharArray()) {
                set.add(c);
            }
            if (set.size() == setSize) {
               isWCOIL = true;
            }
        } else {
            for (char c : str2.toCharArray()) {
                set.add(c);
            }
            int setSize = set.size();
            for (char c : str1.toCharArray()) {
                set.add(c);
            }
            if (set.size() == setSize) {
                isWCOIL = true;
            }
        }
        return isWCOIL;
    }
}
