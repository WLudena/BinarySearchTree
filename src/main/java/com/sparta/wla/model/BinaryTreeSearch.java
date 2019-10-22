package com.sparta.wla.model;

import com.sparta.wla.exceptions.ChildNotFoundException;

import java.util.ArrayList;

public class BinaryTreeSearch implements BinaryTree {

    private Node root;

    public BinaryTreeSearch(){
    }

    @Override
    public int getRootElement() {
        return root.getKey();
    }

    @Override
    public int getNumberOfElements() {
        return initialArray.size();
    }

    @Override
    public void addElement(int element) {
        recursiveInsertion(root, element);
    }

    @Override
    public void addElements(int[] elements) {
        for(int i = 0; i < elements.length; i++){
            root = recursiveInsertion(root, elements[i]);
        }
        recursiveSaveInArrayAsc(arrayAsc,root);
        recursiveSaveInArrayDesc(arrayDesc,root);
    }

    public Node recursiveInsertion(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key < root.key) {
            root.left = recursiveInsertion(root.left, key);
        }else{
            root.right = recursiveInsertion(root.right, key);
        }

        return root;
    }

    public ArrayList<Integer> recursiveSaveInArrayAsc(ArrayList<Integer>arrayAsc, Node root){
        if(root != null){
            recursiveSaveInArrayAsc(arrayAsc, root.left);
            this.arrayAsc.add(root.key);
            recursiveSaveInArrayAsc(arrayAsc, root.right);
        }
        return this.arrayAsc;
    }

    public ArrayList<Integer> recursiveSaveInArrayDesc(ArrayList<Integer>arrayDesc, Node root){
        if(root != null){
            recursiveSaveInArrayAsc(arrayDesc, root.right);
            this.arrayDesc.add(root.key);
            recursiveSaveInArrayAsc(arrayDesc, root.left);
        }
        return this.arrayDesc;
    }


    @Override
    public boolean findElement(int value) {
        return false;
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
        int[] sortedArray = new int[arrayAsc.size()] ;
        for(int i = 0; i < arrayAsc.size(); i++){
            sortedArray[i] = arrayAsc.get(i);
        }
        return sortedArray;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] sortedArray = new int[arrayDesc.size()] ;
        for(int i = 0; i < arrayDesc.size(); i++){
            sortedArray[i] = arrayDesc.get(i);
        }
        return sortedArray;
    }
}
