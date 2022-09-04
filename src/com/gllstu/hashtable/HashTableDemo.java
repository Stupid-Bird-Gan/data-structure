package com.gllstu.hashtable;

import java.util.Scanner;

/**
 * @author LinJun
 * @version 1.0
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        String key="";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("exit:退出系统");
            key=scanner.next();
            switch (key){
                case "add":
                    System.out.print("输入id：");
                    int id=scanner.nextInt();
                    System.out.print("输入名字：");
                    String name=scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "exit":
                    System.exit(0);
                    scanner.close();
                default:
                    break;
            }
        }
    }
}
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class EmpLinkedList{
    private Emp head=null;
    //添加雇员的方法
    public void add(Emp emp){

        if (head==null){
            head=emp;
        }
        Emp temp=head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=emp;
    }
    //遍历链表的雇员信息
    public void list(){
        if (head==null){
            System.out.println("空");
            return;
        }
        System.out.println("当前链表的信息为：");
        Emp temp = head;
        while (true){
            System.out.println("name="+temp.name+" id="+temp.id);
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
    }
    //根据id查找雇员
    public Emp find(int id){
        if (head==null){
            return null;
        }
        Emp temp = head;
        while (true){
            if (temp.id==id){
                break;
            }
            if (temp.next==null){
                return null;
            }
            temp= temp.next;
        }
        return temp;
    }
}
//创建哈希表
class HashTable{
    private EmpLinkedList[] arr;
    public int size;
    public HashTable(int size){
        //初始化数组
        this.size=size;
        arr=new EmpLinkedList[size];
        for (int i=0;i<arr.length;i++){
            arr[i]=new EmpLinkedList();
        }
    }
    //添加雇员
    public void add(Emp emp){
        int No = hashFun(emp.id);
        arr[No].add(emp);
    }
    //遍历方法
    public void list(){
        for (int i=0;i<arr.length;i++){
            arr[i].list();
        }
    }
    //根据id查找雇员
    public void find(int id){
        int No = hashFun(id);
        Emp emp = arr[No].find(id);
        if (emp==null){
            System.out.println("没有找到");
        }else {
            System.out.println("找到");
        }

    }
    //编写散列函数，得到序号
    public int hashFun(int id){
        return id%size;
    }
}