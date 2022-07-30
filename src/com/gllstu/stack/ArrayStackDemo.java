package com.gllstu.stack;

import java.util.Scanner;

/**
 * @author LinJun
 * @version 1.0
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("s:遍历栈元素");
            System.out.println("pp:出栈");
            System.out.println("ph:入栈");
            System.out.println("e：退出");
            key = scanner.next();
            switch (key){
                case "s":
                    arrayStack.print();
                    break;
                case "pp":
                    try {
                        int res = arrayStack.pop();
                        System.out.println("出栈的数据为："+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());;
                    }
                    break;
                case "ph":
                    System.out.print("请输入一个数");
                    int data = scanner.nextInt();
                    arrayStack.push(data);
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}
class ArrayStack{
    private int size;//栈的大小
    private int[] stack ;
    private int top = -1;

    public ArrayStack(int size) {
        this.size = size;
        stack = new int[size];
    }

    //判断栈是否满
    public boolean isFull(){
        return top==size-1;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return top==-1;
    }
    //入栈
    public void push(int data){
        if (isFull()) {
            return;
        }
        stack[++top]=data;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }
    //遍历栈
    public void print(){
        if (isEmpty()){
            return;
        }
        for (int i = top; i>=0 ; i--) {
            System.out.println(stack[i]);
        }
    }
}