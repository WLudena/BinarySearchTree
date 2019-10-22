package com.sparta.wla.managers;


import com.sparta.wla.model.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class TreeHelper {

    private static boolean flag;// Used to find element in tree

    public final int nodeCount(Node root){
        int count = 1;
        if(root == null){
            return 0;
        }else{
            count += nodeCount(root.getLeft());
            count += nodeCount(root.getRight());
        }
        return count;
    }

    public final Node insertNode(Node root, int key){
        if(root == null){
            return new Node(key);
        }
        if(key < root.getKey()) {
            root.setLeft(insertNode(root.getLeft(),key));
        }else{
            root.setRight(insertNode(root.getRight(),key));
        }
        return root;
    }

    public final int[] sortedTreeArray(Node node, int[] array, int index) {
        if(node != null){
            sortedTreeArray(node.getLeft(),array, index);
            array[index++] = node.getKey();
            sortedTreeArray(node.getRight(), array, index);
        }
        return array;
    }

    public final int[] reverseSortedTreeArray(int[] array){
        List<Integer> elementList = new ArrayList<Integer>(); //Tried casting but did not work
        for(int i : array){
            elementList.add(i);
        }
        Collections.reverse(elementList);
        int[] sortedList = new int[array.length];
        for(int i = 0; i < sortedList.length; i++){
            sortedList[i] = elementList.get(i);
        }

        return sortedList;
    }

    public final boolean findNode(Node node, int element){
        if(node != null){
            if(node.getKey() == element){
                return flag = true;
            }
            if(!flag && node.getLeft() != null){
                findNode(node.getLeft(),element);
            }
            if(!flag && node.getRight() != null){
                findNode(node.getRight(),element);
            }
        }
       return flag;
    }

}
