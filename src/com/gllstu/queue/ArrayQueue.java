package com.gllstu.queue;

import java.util.Scanner;

/**
 * @author LinJun
 * @version 1.0
 */
public class ArrayQueue {
    public static void main(String[] args) {
        ArrayQ q = new ArrayQ(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s：显示队列");
            System.out.println("e：退出队列");
            System.out.println("a：添加队列");
            System.out.println("g：取出队列");
            System.out.println("h：查看头数据");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    q.showQueue();
                    break;
                case 'a':
                    System.out.print("请输入一个数：");
                    int value = scanner.nextInt();
                    q.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = q.getQueue();
                        System.out.println(res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int data = q.headQueue();
                        System.out.println("头数据就是"+data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;

            }
        }
    }
}

//编写一个类，数组模拟队列
class ArrayQ {
    private int maxSize;//表示数组最大的容量
    private int front;//头
    private int rear;//尾
    private int[] arr;//该数组用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQ(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear ==front;
    }

    //添加数据到队列
    public void addQueue(int data){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }

        arr[++rear] = data;
    }
    //数据出队
    public int getQueue(){
        if (isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[++front];
    }

    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("空");
            return;
        }
        for (int i=front+1;i<=rear;i++){
            System.out.print("arr["+i+"]="+arr[i]+"\n");
        }
    }

    //显示队列的头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("空");
        }
        return arr[front+1];
    }
}
class Animal{}
class Cat extends Animal{}
class Dog extends Animal{}