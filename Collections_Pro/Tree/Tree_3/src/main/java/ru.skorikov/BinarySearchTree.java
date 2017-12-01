package ru.skorikov;

import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @param <E> параметр.
 * @ author: Alex_Skorikov.
 * @ date: 27.11.17
 * @ version: java_kurs_standart
 * 3. Собственная реализация Binary search tree
 */
public class BinarySearchTree<E> {
    /**
     * Корневой элемент.
     */
    private Node root;
    /**
     * Следующий элемент.
     */
    private Node newNode;
    /**
     * Данные узла по ключу.
     */
    private E searchNodeByKey;
    /**
     * Максимальный элемент.
     */
    private E maxNode;
    /**
     * Минимальный элемент.
     */

    private E minNode;

    /**
     * Узел.
     * Строительный блок дерева.
     */
    private class Node {
        /**
         * Ключ.
         */
        private int key;
        /**
         * Данные.
         */
        private E value;
        /**
         * Левая ветка.
         */
        private Node left;
        /**
         * Правая ветка.
         */
        private Node right;

        /**
         * Конструктор принимет данные.
         * Ключ вычисляем по хэшкоду.
         *
         * @param value данные.
         * @param key   ключ.
         */
        Node(int key, E value) {
            this.key = key;
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    /**
     * Конструктор дерева.
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Получить корень.
     *
     * @return корень.
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Добавить узел в дерево.
     *
     * @param value данные.
     * @param key   ключ.
     */
    public void add(int key, E value) {
        if (root == null) {
            root = new Node(key, value);
            newNode = root;
        } else {
            if (newNode.key <= key) {
                if (newNode.right == null) {
                    newNode.right = new Node(key, value);
                } else {
                    newNode = newNode.right;
                    add(key, value);
                }
            } else {
                if (newNode.left == null) {
                    newNode.left = new Node(key, value);
                } else {
                    newNode = newNode.left;
                    add(key, value);
                }
            }
        }
        newNode = root;
    }

    /**
     * Получить данные узла по ключу.
     *
     * @param node узел.
     * @param key  ключ.
     * @return данные ключа.
     */
    public E getNode(Node node, int key) {
        if (node != null) {
            if (node.key == key) {
                searchNodeByKey = node.value;
            } else {
                if (key > node.key) {
                    getNode(node.right, key);
                } else {
                    getNode(node.left, key);
                }
            }
        }
        if (searchNodeByKey != null) {
            return searchNodeByKey;
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Поиск макимума.
     *
     * @param node стартовый узел.
     * @return максимум.
     */
    public E maxNode(Node node) {

        if (node != null) {
            if (node.right == null) {
                maxNode = node.value;
            } else {
                maxNode(node.right);
            }
        }
        if (maxNode != null) {
            return maxNode;
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Поиск минимума.
     *
     * @param node стартовый узел.
     * @return минимум.
     */
    public E minNode(Node node) {
        if (node != null) {
            if (node.left == null) {
                minNode = node.value;
            } else {
                minNode(node.left);
            }
        }
        if (minNode != null) {
            return minNode;
        } else {
            throw new NoSuchElementException();
        }
    }
}