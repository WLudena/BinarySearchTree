package com.sparta.wla;

import com.sparta.wla.exceptions.ChildNotFoundException;
import com.sparta.wla.model.BinaryTree;
import com.sparta.wla.model.BinaryTreeSearch;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class BinaryTreeTest
{
    private BinaryTree binaryTree;

    @Before
    public void setUp(){
        binaryTree = new BinaryTreeSearch(5);
        binaryTree.addElements(new int[]{23,12,67,4,56,3,7,31});
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testContainsRootElement(){
        int actual = binaryTree.getRootElement();
        assertEquals(5, actual);
    }

    @Test
    public void testGetsNumberOfElements(){
        int numberOfElements = binaryTree.getNumberOfElements();
        assertEquals(numberOfElements,9);
    }

    @Test
    public void testAddsElement(){
        int initialLength = binaryTree.getNumberOfElements();
        binaryTree.addElement(3);
        int afterLength = binaryTree.getNumberOfElements();
        assertEquals(afterLength, initialLength + 1);
    }

    @Test
    public void testAddsElements(){
        int initialLength = binaryTree.getNumberOfElements();
        binaryTree.addElements(new int[]{11, 21, 9});
        int afterLength = binaryTree.getNumberOfElements();
        assertEquals(afterLength, initialLength + 3);
    }

    @Test
    public void testFindElement(){
        boolean found = binaryTree.findElement(12);
        assertTrue(found);
    }

    @Test
    public void testNotFoundElement(){
        boolean notFound = binaryTree.findElement(112);
        assertFalse(notFound);
    }

    @Test
    public void testGetLeftChild(){
        try{
            int leftChild = binaryTree.getLeftChild(23);
            assertEquals(12, leftChild);
        }catch (ChildNotFoundException e){

        }
    }

    @Test
    public void getsRightChild(){
        try{
            int rightChild = binaryTree.getRightChild(23);
            assertEquals(rightChild, 67);
        }catch (ChildNotFoundException e){

        }
    }

    @Test(expected = ChildNotFoundException.class)
    public void testThrowsChildNotFoundException() throws ChildNotFoundException{
        int rightChild = binaryTree.getRightChild(3);
    }

    @Test
    public void testGetsSortedTreeAsc(){
        int[] sortedArray = binaryTree.getSortedTreeAsc();
        System.out.printf(Arrays.toString(sortedArray));
        assertArrayEquals(sortedArray, new int[]{3,4,5,7,12,23,31,56,67});
    }

    @Test
    public void testGetsSortedTreeDesc(){
        int[] sortedArray = binaryTree.getSortedTreeDesc();
        assertArrayEquals(sortedArray,new int[] {8,7,5,3});
    }

}
