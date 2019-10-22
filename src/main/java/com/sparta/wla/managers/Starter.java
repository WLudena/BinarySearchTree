package com.sparta.wla.managers;

import com.sparta.wla.model.BinaryTree;
import com.sparta.wla.model.BinaryTreeSearch;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Starter
{
    public static void main( String[] args )
    {
        //BinaryTreeSearch binaryTreeSearch = new BinaryTreeSearch();
        BinaryTree binaryTree = new BinaryTreeSearch();
        int[] testNumbers = {6,2,5,4,8,1};
        binaryTree.addElements(testNumbers);
        System.out.println(Arrays.toString(binaryTree.getSortedTreeAsc()));
        System.out.println(Arrays.toString(binaryTree.getSortedTreeDesc()));

    }
}
