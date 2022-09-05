package com.gllstu.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author LinJun
 * @version 1.0
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr={13,7,8,3,29,6,1};
        createHuffmanTree(arr);//huffman
        //000000
    }
    //前序遍历
    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("空树");
        }
    }
    public static void createHuffmanTree(int[] arr){
        //为了操作方便，遍历arr，将其构成Node
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value:arr){
            nodes.add(new Node(value));
        }
        //排序
        while (nodes.size()>1) {
            Collections.sort(nodes);
            //取出最小的结点
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.value + right.value);
            parent.left=left;
            parent.right=right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        preOrder(nodes.get(0));
    }
}
class Node implements Comparable<Node>{
    public int value;
    public Node left;
    public Node right;
    public Node(int value){
        this.value=value;
    }
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
        //表示从小到大排序
    }
}