package com.gllstu.linkedlist;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author LinJun
 * @version 1.0
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        Node node = new Node(3);
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        SingleList.add(node);
        SingleList.add(node1);
        SingleList.add(node2);
//        SingleList.tailAdd(node);
//        SingleList.tailAdd(node1);
//        SingleList.tailAdd(node2);
       // SingleList.change(3,4);
//        SingleList.print();
//        SingleList.delete(4);
//        SingleList.delete(5);
//        SingleList.delete(3);
//        SingleList.print();
//        System.out.println(SingleList.getLength(SingleList.getHead()));
//        System.out.println(SingleList.getK(SingleList.getHead(),7));
//        SingleList.reverseList(SingleList.getHead());
//        SingleList.print();
//        SingleList.reversePrint1(SingleList.getHead().next);
//        SingleList.reversePrint2(SingleList.getHead());
        Node node3 = new Node(1);
        Node node4 = new Node(2);
        Node node5= new Node(6);
        List2.add(node3);
        List2.add(node4);
        List2.add(node5);

      SingleList.mix(SingleList.getHead(),List2.getHead());
      SingleList.print();

    }
}
class SingleList{
    //初始化一个头节点
    private static Node head = new Node(0);

    public static Node getHead() {
        return head;
    }

    //添加节点的方法,尾插法
    public static void add(Node newNode){
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    //头插法
    public static void tailAdd(Node newNode){
        Node temp = head;
        newNode.next =temp.next;
        temp.next = newNode;
    }
    //遍历链表
    public static void  print(){
        //判断链表是否为空
        if (head.next==null){
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
            System.out.println(temp);

        }
    }
    //修改节点的信息
    public static void change(int data,int newData){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        Node temp = head;
        while (temp!=null){
            temp=temp.next;
            if (temp.data==data){
                temp.data = newData;
                break;
            }
        }

    }
    //删除节点
    public static void delete(int data){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        Node temp = head;
        while (temp!=null){
            if(temp.next.data==data){
                temp.next=temp.next.next;
                break;
            }
            temp = temp.next;

        }

    }
    //获取节点的个数
    public static int getLength(Node head){
        if (head.next==null){
            return 0;
        }
        Node temp = head;
        int length=0;
        while (temp.next!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
    //获取倒数第k个节点
    public static Node getK(Node head,int k){
        if (head.next==null){
            return null;
        }
        int size = getLength(head);
        //第二次遍历size-k
        if (k<=0||k>size){
            return null;
        }
        Node temp = head;
        for (int i=0;i<=size-k;i++){
            temp=temp.next;
        }
        return temp;
    }
    //反转链表
    public static void reverseList(Node head){
        if (head.next==null&&head.next.next==null){
            return;
        }
        Node temp = head.next;
        Node next = null;
        Node node = new Node(-1);
        while (temp!=null){
          next = temp.next;
          temp.next = node.next;
          node.next = temp;
          temp = next;
        }
        head.next = node.next;
    }
    //递归的方式逆序打印单链表
    public static void reversePrint1(Node temp){
        if (temp==null){
            return;
        }
        reversePrint1(temp.next);
        System.out.println(temp.data);
    }
    //用栈的方式
    public static void reversePrint2(Node head){
        if (head.next==null){
            System.out.println("kong");
        }
        Stack<Node> nodes = new Stack<>();
        Node temp = head.next;
        while (temp!=null){
            nodes.push(temp);
            temp=temp.next;
        }
        //将栈中的节点出战并打印
        while (nodes.size()>0){
            System.out.println(nodes.pop());
        }
    }
    //合并两个有序链表
    public static void mix(Node head1,Node head2){
        if (head1.next==null&&head2.next==null){
            System.out.println("两个链表为空");
            return ;
        }else if (head1.next==null&&head2.next!=null){
            head1.next=head2.next;
        }else if (head1.next!=null&&head2.next==null){
            return ;
        }else{
            Node newHead = new Node(-1);
            Node temp1 = head1.next;
            Node temp2 = head2.next;
            Node next = newHead;
            while (temp1!=null&&temp2!=null){
                if (temp1.data<temp2.data){
                    next.next = temp1;
                    next=temp1;
                    temp1=temp1.next;
                }else {
                    next.next = temp2;
                    next=temp2;
                    temp2=temp2.next;
                }
            }
            while (temp1!=null){
               next.next= temp1;
               next= temp1;
               temp1 = temp1.next;
            }
            while (temp2!=null){
                next.next= temp2;
                next= temp2;
                temp2 = temp2.next;
            }
            head1.next = newHead.next;
        }

    }
}
class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
class List2{
    private static Node head = new Node(0);

    public static Node getHead() {
        return head;
    }

    //添加节点的方法,尾插法
    public static void add(Node newNode){
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    public static void  print(){
        //判断链表是否为空
        if (head.next==null){
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
            System.out.println(temp);

        }
    }
}