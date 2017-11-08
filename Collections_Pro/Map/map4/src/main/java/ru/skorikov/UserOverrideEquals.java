package ru.skorikov;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 07.11.17
 * @ version: java_kurs_standart
 */
public class UserOverrideEquals {
    /**
     * Run application.
     * @param args arguments
     */
    public static void main(String[] args) {
        User user1 = new User("Name1", 2, 1, 2, 1990);
        User user2 = new User("Name1", 2, 1, 2, 1990);

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());

        System.out.println(map);
    }
}

