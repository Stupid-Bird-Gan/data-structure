package com.gllstu.search;

/**
 * @author LinJun
 * @version 1.0
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, -2, 3, 4, -7};
        int index = seqSearch(arr, 8);
        if (index == -1) {
            System.out.println("null");
        }

        //System.out.println(seqSearch(arr,7));
    }

    public static int seqSearch(int[] arr, int data) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }
}
