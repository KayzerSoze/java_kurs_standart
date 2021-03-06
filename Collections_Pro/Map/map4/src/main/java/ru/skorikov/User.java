package ru.skorikov;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 *
 * @author:AlexSkorikov.
 * @version:java_kurs_standart
 */
public class User {
    /**
     * Field name.
     */
    private String name;
    /**
     * Field children.
     */
    private int children;
    /**
     * Field birthday.
     */
    private Calendar birthday = Calendar.getInstance();

    /**
     * Create new User.
     *
     * @param name     name.
     * @param children children.
     * @param day      dayBirthday
     * @param month    mounthBirthday
     * @param year     yearBirthday.
     */
    public User(String name, int children, int day, int month, int year) {
        this.name = name;
        this.children = children;
        this.birthday.set(year, month - 1, day);

    }

    /**
     * Get User name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set User name.
     *
     * @param name name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get User children.
     *
     * @return children.
     */
    public int getChildren() {
        return children;
    }

    /**
     * Set User children.
     *
     * @param children children.
     */
    public void setChildren(int children) {
        this.children = children;
    }

    /**
     * Get User birthday.
     *
     * @return birthday.
     */
    public Calendar getBirthday() {
        return birthday;
    }

    /**
     * Set birthday.
     *
     * @param day   new Day
     * @param month new Mouth
     * @param year  new Year
     */
    public void setBirthday(int day, int month, int year) {
        this.birthday.set(year, month - 1, day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (children != user.children) {
            return false;
        }

        if (birthday.getTime().getDay() != user.birthday.getTime().getDay()) {
            return false;
        }
        if (birthday.getTime().getMonth() != user.birthday.getTime().getMonth()) {
            return false;
        }
        if (birthday.getTime().getYear() != user.birthday.getTime().getYear()) {
            return false;
        }

        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
