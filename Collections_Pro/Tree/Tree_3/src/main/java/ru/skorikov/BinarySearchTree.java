package ru.skorikov;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 27.11.17
 * @ version: java_kurs_standart
 * 3. Собственная реализация Binary search tree
 * @param <E> параметр.
 */
public class BinarySearchTree<E> {

    private Node root;
    private Node newNode;

    private class Node {
        private int key;
        private E value;
        private Node left;
        private Node right;

        public Node(E value) {
            this.key = value.hashCode()/10;
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public void add(E value) {
        if (root == null) {
            root = new Node(value);
            newNode = root;
        } else {
            if (value.hashCode()/10 > newNode.key) {
                if (newNode.right == null) {
                    newNode.right = new Node(value);
                } else {
                    newNode = newNode.right;
                    add(value);
                }
            }
            if (value.hashCode()/10 <= newNode.key) {
                if (newNode.left == null) {
                    newNode.left = new Node(value);
                } else {
                    newNode = newNode.left;
                    add(value);
                }
            }
        }
    }

    List<E> list = new ArrayList<>();

    public void createList(Node node) {
        list.add(node.value);
        if (node.right != null){
            createList(node.right);
        }
        if (node.left != null){
            createList(node.left);
        }


    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(31);
        tree.add(4);
        tree.add(5);
        tree.add(63);
        tree.add(7);
        tree.add(8);
        tree.add(9);

        tree.createList(tree.root);
        for (Integer booo : tree.list) {
            System.out.println(booo);
        }


        System.out.println();

    }
}
