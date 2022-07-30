package com.gllstu.linkedlist;

/**
 * @author LinJun
 * @version 1.0
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
//        DoubleLinkedList.add(node1);
//        DoubleLinkedList.add(node2);
//        DoubleLinkedList.add(node3);
        DoubleLinkedList.tailAdd(node1);
        DoubleLinkedList.tailAdd(node2);
        DoubleLinkedList.tailAdd(node3);

        DoubleLinkedList.print();

        DoubleLinkedList.change(1,8);
        DoubleLinkedList.print();

        DoubleLinkedList.delete(8);
        DoubleLinkedList.print();
    }
}
class Node2{
    public int data;
    public Node2 pre;
    public Node2 next;

    public Node2(int data) {
        this.data = data;
    }
    public Node2(){

    }

    @Override
    public String toString() {
        return "Node2{" +
                "data=" + data +
                '}';
    }
}
class DoubleLinkedList{
    //初始化一个头节点
    private static Node2 head = new Node2();
    //返回头节点
    public static Node2 getHead(){
        return head;
    }
    //遍历双向链表
    public static void  print(){
        //判断链表是否为空
        if (head.next==null){
            return;
        }
        Node2 temp = head;
        while(temp.next!=null){
            temp=temp.next;
            System.out.println(temp);

        }
    }
    //尾插法添加节点
    public static void add(Node2 newNode){
        Node2 temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.pre = temp;
    }
    //头插法
    public static void tailAdd(Node2 newNode){
        Node2 temp = head;
        newNode.next = temp.next;
        if (temp.next!=null){
            temp.next.pre= newNode;
        }
        temp.next = newNode;
        newNode.pre = temp;
    }

    //修改节点的信息
    public static void change(int data,int newData){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        Node2 temp = head;
        while (temp!=null){
            temp=temp.next;
            if (temp.data==data){
                temp.data = newData;
                break;
            }
        }
    }
    //删除一个节点
    public static void delete(int data){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        Node2 temp = head.next;
        while (temp!=null){
            if(temp.data==data){
                temp.pre.next=temp.next;
                if(temp.next!=null) {
                    temp.next.pre = temp.pre;//这里如果是最后一个节点会报空指针异常
                }
                break;
            }
            temp = temp.next;
        }
    }

}