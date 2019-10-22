package com.sparta.wla.model;

import org.w3c.dom.*;

public class Node {

    private final int key;
    private Node left, right;

    public Node getLeft() {
        return left;
    }

    public int getKey() {
        return key;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int key){
        this.key = key;
    }
}
