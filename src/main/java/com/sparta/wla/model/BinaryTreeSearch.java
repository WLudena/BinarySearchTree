package com.sparta.wla.model;

import com.sparta.wla.exceptions.ChildNotFoundException;
import com.sparta.wla.managers.TreeHelper;
import java.util.Collections;


public class BinaryTreeSearch implements BinaryTree {

    private Node root;
    private TreeHelper treeHelper = new TreeHelper();

    @Override
    public int getRootElement() {
        return root.getKey();
    }

    @Override
    public int getNumberOfElements(){
        return treeHelper.nodeCount(root);
    }

    @Override
    public void addElement(int element) {
        treeHelper.insertNode(root, element);
    }

    @Override
    public void addElements(int[] elements) {
        for(int i = 0; i < elements.length; i++){
            root = treeHelper.insertNode(root,elements[i]);
        }
    }

    @Override
    public boolean findElement(int value) {
        return treeHelper.findNode(root,value);
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] sortedTreeArray = new int[getNumberOfElements()];
        return treeHelper.sortedTreeArray(root,sortedTreeArray, 0);
    }

    @Override
    public int[] getSortedTreeDesc() {
        return treeHelper.reverseSortedTreeArray(getSortedTreeAsc());
    }
}
