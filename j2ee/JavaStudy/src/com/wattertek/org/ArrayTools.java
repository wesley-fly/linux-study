package com.wattertek.org;

/**
 * @author Xiaofan Lee
 * @version 1.0
 */
public class ArrayTools {
    /**
    * private init class
    */
    private ArrayTools(){}

    /** swap array
     * @param a index a
     * @param b index b
     */
    public static void swap(int[] arr, int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    /**
     * print array
     */
    public static void printArray(int[] arr)
    {
        System.out.println("Max = " + arr[0]);
    }
}
