package ru.skorikov;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 09.01.18
 * @ version: java_kurs_standart
 * <p>
 * Класс структура данных для хранение пользователей.
 */
@ThreadSafe
class UserStorage {

    /**
     * Хранилище пользователей.
     */
    private List<User> list = new LinkedList<>();

    /**
     * Получить лист пользователей.
     * @return лист.
     */
    @GuardedBy("this")
    List<User> getList() {
        return list;
    }

    /**
     * Добавить user.
     *
     * @param user user.
     * @return addOrNo.
     */
    synchronized boolean add(User user) {
        boolean isAdd = false;

        if (user != null) {
            list.add(user);
            isAdd = true;
        }
        return isAdd;
    }

    /**
     * Обновить user.
     *
     * @param user user.
     * @return updateOrNo.
     */
    synchronized boolean update(User user) {
        boolean isUpdate = false;

        if (user != null) {
            if (list.contains(user)) {
                list.remove(user);
                list.add(user);
                isUpdate = true;
            } else {
                throw new NoSuchElementException();
            }
        }
        return isUpdate;
    }

    /**
     * Удалить user.
     *
     * @param user user.
     * @return deleteOrNo.
     */
    synchronized boolean delete(User user) {
        boolean isDelete = false;

        if (user != null) {
            if (list.contains(user)) {
                list.remove(user);
                isDelete = true;
            } else {
                throw new NoSuchElementException();
            }
        }
        return isDelete;
    }

    /**
     * Перевод одного user другому.
     *
     * @param fromId Id user1.
     * @param toId   Id user2.
     * @param amount сумма.
     */
    synchronized void transfer(int fromId, int toId, int amount) {
        User user1 = new User(fromId);
        User user2 = new User(toId);

        Iterator<User> iterator = list.iterator();
        if (list.contains(user1) && list.contains(user2)) {
            while (iterator.hasNext()) {
                User temp = iterator.next();
                if (temp.equals(user1)) {
                    temp.setAmount(temp.getAmount() - amount);
                }
                if (temp.equals(user2)) {
                    temp.setAmount(temp.getAmount() + amount);
                }
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
