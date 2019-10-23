package com.sparta.wla.managers;


import com.sparta.wla.model.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class TreeHelper {

    private static boolean flag;// Used to find element in tree
    private static int count;

    public static int nodeCount(Node root){
        int count = 1;
        if(root == null){
            return 0;
        }else{
            count += nodeCount(root.getLeft());
            count += nodeCount(root.getRight());
        }
        return count;
    }

    public static int[] reverseSortedTreeArray(int[] array){
        ArrayList<Integer> temp = new ArrayList<>(arrayToArrayList(array));
        Collections.reverse(temp);
        return arrayListToArray(temp);
    }

    private static int[] arrayListToArray(List<Integer> arrayList){
        int[]array = new int[arrayList.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = arrayList.get(i);
        }
        return array;
    }

    private static List<Integer> arrayToArrayList(int[] array){
        List<Integer> arrayList = new ArrayList<>();
        for(int i : array){
            arrayList.add(i);
        }
        return arrayList;
    }

}
