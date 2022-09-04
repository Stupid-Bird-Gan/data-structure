package com.gllstu.polandnotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LinJun
 * @version 1.0
 */
public class PolandNotation {
    public static void main(String[] args) {
        //创建一个后缀表达式
        String expression = "30 4 + 5 * 6 -";
        //1.先将"3 4 + 5 * 6 -"放到ArrayList中
        //2.将ArrayList传递给一个方法，遍历Arraylist配合栈完成计算
//        List<String> list = getListString(expression);
//        System.out.println(list);
//        System.out.println(calculate(list));
        String expression2 = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        List<String> list = getStringList(expression2);
        System.out.println(list);
        List<String> parse = parse(list);
        System.out.println(parse);
        System.out.println(calculate(parse));

    }
    public static List<String> getListString(String expression){
        //将expression分割
        String[] s = expression.split(" ");
        List<String> strings = new ArrayList<>();
        for (String s1 :s) {
            strings.add(s1);
        }
        return strings;
    }
    public static int calculate(List<String> list){
        //创建一个栈
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String s :list) {
            //正则表达式取出数
            if (s.matches("\\d+")){
                stack.push(s);
            }else{
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (s.equals("+")){
                    res = num1+num2;
                }else if (s.equals("-")){
                    res = num2-num1;
                }else if (s.equals("*")){
                    res = num2*num1;
                }else if (s.equals("/")){
                    res = num2/num1;
                }else {
                    System.out.println("有错");
                }
                stack.push(res+"");
            }
        }
         return Integer.parseInt(stack.pop());
    }
    //将中缀表达式转成对应的List
    public static List<String> getStringList(String expression){
        //定义一个List
        List<String> list = new ArrayList<>();
       // int i =0;//用于遍历字符串
        String[] s = expression.split(" ");
        for (String s1 :s) {
            list.add(s1);
        }
         return list;
    }
    //中缀转后缀
    public static List<String> parse(List<String> list){
        //先定义两个栈
        Stack<String> s1 = new Stack<>();
        //Stack<String> s2 = new Stack<>();//这个栈没有出栈操作，待会返回的时候顺序是反的，所以改用Arraylist存储
        List<String> arrayList = new ArrayList<>();
        for (String s:list){
            //如果是一个数就加入arraylist
            if (s.matches("\\d+")){
                arrayList.add(s);
            }else if (s.equals("(")){
                s1.push(s);
            }else if(s.equals(")")){
                while(!s1.peek().equals("(")){
                    arrayList.add(s1.pop());
                }
                s1.pop();//消除小括号
            }else {
                //看运算符的优先级,当小于时
                while (s1.size()!=0&&Operation.getValue(s1.peek())>Operation.getValue(s)){
                    arrayList.add(s1.pop());
                }
                s1.push(s);
            }
        }
        while (s1.size()!=0){
            arrayList.add(s1.pop());
        }
        return arrayList;
    }

}
//编写一个类Operation
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;
    //写一个方法返回对应的优先级数字
    public static int getValue(String opera){
        int result = 0;
        switch (opera){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;

    }

}