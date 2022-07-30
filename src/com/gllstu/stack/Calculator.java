package com.gllstu.stack;

import javax.jws.soap.SOAPMessageHandlers;

/**
 * @author LinJun
 * @version 1.0
 */
public class Calculator {
    public static void main(String[] args) {
        String expression  = "7-2*6+2";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operaStack = new ArrayStack2(10);
        //int index = 0;
        int num1 =0;
        int num2 = 0;
        int res =0;
        int opera = 0;
        String keepNum = "";
        //char ch = ' ';
        //开始循环扫描表达式
        char[] chars = expression.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (operaStack.isOperation(chars[i])){
                //判断当前符号栈是否为空
                if (operaStack.isEmpty()){
                    operaStack.push(chars[i]);
                }else{
                    if (operaStack.priority(chars[i])<= operaStack.priority(operaStack.peek())){
                        //弹出两个数
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        opera = operaStack.pop();
                        res = operaStack.cal(num1,num2,opera);
                        numStack.push(res);
                        operaStack.push(chars[i]);
                    }else {
                        operaStack.push(chars[i]);
                    }
                }
            }else {
                numStack.push(chars[i]-48);
                //1.当处理多位数时，不能发现一个数就立即入栈，因为可能是多位数

            }
        }
        while (true){
            if (operaStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            opera = operaStack.pop();
            res = operaStack.cal(num1,num2,opera);
            numStack.push(res);
        }
        System.out.println(numStack.pop());
    }
}
class ArrayStack2{
    private int size;//栈的大小
    private int[] stack ;
    private int top = -1;

    public ArrayStack2(int size) {
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
    //返回运算符的优先级，用数字的大小来表示优先级
    public int priority(int operation){
        if (operation=='*'||operation=='/'){
            return 1;
        }else if (operation=='+'||operation=='-'){
            return 0;
        }else {
            return -1;
        }
    }
    //判断是否是一个操作符
    public boolean isOperation(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    //计算方法
    public int cal(int num1,int num2,int operation){
        int res = 0;
        switch (operation){
            case '+':
                res = num1+num2;
                break;
            case '-':
                res = num2-num1;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
            default:
                break;
        }
        return res;
    }
    //返回栈顶的元素，但不出栈
    public int peek(){
        return stack[top];
    }
}