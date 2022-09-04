package com.gllstu.tree;

/**
 * @author LinJun
 * @version 1.0
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}
class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //完成顺序存储二叉树的前序遍历
    //index表示数组的下标
    public void preOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空");
        }
        //输出当前的元素
        System.out.println(arr[index]);
        if (2*index+1<arr.length){
            preOrder(2*index+1);
        }
        if (2*index+2<arr.length){
            preOrder(2*index+2);
        }
    }
    public void preOrder(){
        this.preOrder(0);
    }
}