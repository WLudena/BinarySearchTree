package com.sparta.wla.model;

import com.sparta.wla.exceptions.ChildNotFoundException;

public class BinaryTreeSearch implements BinaryTree {

    private Node root;
    private static int nodeCount = 0;
    private static int indexCount = 0;

    public BinaryTreeSearch(int element){
        root = new Node(element);
        nodeCount++;
    }


    @Override
    public int getRootElement() {
        return root.getKey();
    }

    @Override
    public int getNumberOfElements(){
        return nodeCount;
    }

    @Override
    public void addElement(int element) {
        insertNode(root, element);
        nodeCount++;
    }

    @Override
    public void addElements(int[] elements) {
        for(int i = 0; i < elements.length; i++){
            insertNode(root,elements[i]);
            nodeCount++;
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
        int[] sortedTreeArray = new int[nodeCount];
        return sortedTreeArrayHelper(root,sortedTreeArray);
    }

    @Override
    public int[] getSortedTreeDesc() {

        int[] descSortedArray = new int[nodeCount];
        int j = nodeCount - 1;
        int[] ascSortedArray = getSortedTreeAsc();

        for(int i = 0; i < ascSortedArray.length; i++){
            descSortedArray[i] = ascSortedArray[j];
            j--;
        }
        return descSortedArray;
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
        }else{
            node.setRight(insertNode(node.getRight(),key));
        }
        return node;
    }

    private int[] sortedTreeArrayHelper(Node node, int[] array){
        if(node != null){
           sortedTreeArrayHelper(node.getLeft(), array);
           array[indexCount] = node.getKey();
           indexCount++;
           sortedTreeArrayHelper(node.getRight(), array);
        }
        return array;
    }

}
