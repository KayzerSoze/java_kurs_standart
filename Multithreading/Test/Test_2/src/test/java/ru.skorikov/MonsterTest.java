package ru.skorikov;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 05.03.18
 * @ version: java_kurs_standart
 */
public class MonsterTest {
    /**
     * Создадим монстра.
     * @throws InterruptedException exception
     */
    @Test
    public void tryCreateHero() throws InterruptedException {
        Board board = new Board(10);
        Monster monster = new Monster("Monstr", board);
        monster.nextStep(monster.createNewCell(monster.startPosition()));

    }
}