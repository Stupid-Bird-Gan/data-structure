package com.gllstu.linkedlist;

/**
 * @author LinJun
 * @version 1.0
 */
public class JosePhu {
    public static void main(String[] args) {
        CircleLinkedList.add(5);
//        CircleLinkedList.print();
        CircleLinkedList.countNode(2,2,5);
    }
}
class Node3{
    public int data;
    public Node3 next;

    public Node3(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node3{" +
                "data=" + data +
                '}';
    }
}
class CircleLinkedList{
    //创建一个first节点，但是没有编号
    private static Node3 first ;
    public static void add(int nums){
        if (nums<=0){
            System.out.println("nums大小不正确");
            return;
        }
        Node3 second = null;
        for (int i = 1; i <= nums; i++) {
            Node3 node = new Node3(i);
            //第一个比较特殊
            if (i==1){
                first = node;
                first.next = first;
                second = first;
            }else {
                second.next = node;
                second = node;
                second.next = first;
            }
        }
    }
    //遍历
    public static void print(){
        if (first==null){
            System.out.println("kong");
            return;
        }
        Node3 second = first;
        while (true){
            System.out.println(second);
            if (second.next==first){
                break;
            }
            second = second.next;
        }
    }

    //约瑟夫问题
    public static void countNode(int start,int countNum,int nums){
        //start表示从那个开始数
        //countNum表示数几下
        //nums表示有几个节点，方便做校验
        if (first==null||countNum<=0||countNum>nums) {
            System.out.println("参数有问题");
        }
            Node3 p = first;
            //先让指针指向最后节点
            while (p.next!=first){
                p = p.next;
            }
            //移动到目标节点
            for (int i = 0; i < start-1; i++) {
                first = first.next;
                p = p.next;
            }
            while (true){
                if (p==first){
                    break;
                }
                //让first和p同时移动countNum-1
                for (int i = 0; i < countNum-1; i++) {
                    first = first.next;
                    p = p.next;
                }
                System.out.println(first);
                p.next = first.next;
                first = first.next;
            }
            System.out.println(first);

    }
}