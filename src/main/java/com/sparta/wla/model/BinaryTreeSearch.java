package com.sparta.wla.model;

import com.sparta.wla.exceptions.ChildNotFoundException;
import com.sparta.wla.managers.TreeHelper;

public class BinaryTreeSearch implements BinaryTree {

    private Node root;
    private static int count;

    public BinaryTreeSearch(int element){
        root = new Node(element);
    }


    @Override
    public int getRootElement() {
        return root.getKey();
    }

    @Override
    public int getNumberOfElements(){
        return TreeHelper.nodeCount(root);
    }

    @Override
    public void addElement(int element) {
        insertNode(root, element);
    }

    @Override
    public void addElements(int[] elements) {
        for(int i = 0; i < elements.length; i++){
            insertNode(root,elements[i]);
        }
    }

    @Override
    public boolean findElement(int value) {
        if(findNode(root,value).getKey() == value){
            return true;
        }
        return false;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        try{
            if(findNode(root,element).getKey() == element){
                return findNode(root,element).getLeft().getKey(); // Check why it doesn't
            }else{
                return 0;
            }
        }catch (NullPointerException e){
            throw new ChildNotFoundException("Child Not Found");
        }
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        try{
            if(findNode(root,element).getKey() == element){
                return findNode(root,element).getRight().getKey(); // Check why it doesn't
            }else{
                return 0;
            }
        }catch (NullPointerException e){
            throw new ChildNotFoundException("Child Not Found");
        }
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] sortedTreeArray = new int[count];
        return sortedTreeArrayHelper(root,sortedTreeArray);
    }

    @Override
    public int[] getSortedTreeDesc() {

        return TreeHelper.reverseSortedTreeArray(getSortedTreeAsc());
    }

    private Node findNode(Node node, int element){
        if(node != null){
            if(node.getKey() == element){
                return node;
            }
        }

        return element < node.getKey()
        ? findNode(node.getLeft(), element)
        : findNode(node.getRight(), element);
    }

    private Node insertNode(Node node, int key){
        if(node == null){
            return new Node(key);
        }
        if(key < node.getKey()) {
            node.setLeft(insertNode(node.getLeft(),key));
            count++;
        }else{
            node.setRight(insertNode(node.getRight(),key));
            count++;
        }
        return node;
    }

    private int[] sortedTreeArrayHelper(Node node, int[] array){
        if(node == null){
            return array;
        }
        if( count < array.length){
            sortedTreeArrayHelper(node.getLeft(), array);
            array[count] = node.getKey();
            count++;
            sortedTreeArrayHelper(node.getRight(),array);
        }
        return array;
    }
}
