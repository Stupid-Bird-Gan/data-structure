package com.gllstu.tree;

/**
 * @author LinJun
 * @version 1.0
 */
public class BinaryTree {
    public static void main(String[] args) {
        BinaryTrees binaryTrees = new BinaryTrees();
        Node node1 = new Node(1, "tom");
        Node node2 = new Node(2, "mike");
        Node node3 = new Node(3, "jack");
        Node node4 = new Node(4, "marry");
        Node node5 = new Node(5, "kk");
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTrees.setRoot(node1);
//        binaryTrees.preOrder();
//        binaryTrees.infixOrder();
//        binaryTrees.postOrder();
        Node node = binaryTrees.preOrderSearch(5);
        if (node!=null){
            System.out.println(node);
        }
    }

}
//定义一个二叉树
class BinaryTrees{
    private Node root;
    public void setRoot(Node root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }
    }
    //前序查找
    public Node preOrderSearch(int id){
        if (root!=null){
            return root.preOrderSearch(id);
        }else {
            return null;
        }
    }
    //中序查找
    public Node infixOrderSearch(int id){
        if (root!=null){
            return root.infixOrderSearch(id);
        }else {
            return null;
        }
    }
    //后序查找找
    public Node postOrderSearch(int id){
        if (root!=null){
            return root.postOrderSearch(id);
        }else {
            return null;
        }
    }
    //删除节点
    public void delNode(int id){
        if (root!=null){
           if (root.getId()==id){
               root=null;
           }else {
               root.delNode(id);
           }
        }else {
            System.out.println("空树");
        }
    }
}
//创建节点
class Node{
    private int id;
    private String name;
    private Node left;
    private Node right;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //递归删除节点的方法
    public void delNode(int id){
        boolean flag = false;
        if (this.left!=null&&this.left.id==id){
            flag=true;
            this.left=null;
            return;
        }
        if (this.right!=null&&this.right.id==id){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.delNode(id);
        }
        if (this.right!=null){
            this.right.delNode(id);
        }
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }

        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //前序遍历查找
    public Node preOrderSearch(int id){
        if (this.id==id){
            return this;
        }
        Node temp = null;
        if (this.left!=null){
            temp=this.left.preOrderSearch(id);
        }
        if (temp!=null){
            return temp;
        }
        if (this.right!=null){
            temp=this.right.preOrderSearch(id);
        }
        return temp;
    }
    //中序遍历查找
    public Node infixOrderSearch(int id){
        Node temp=null;
        if (this.left!=null){
            temp=this.left.infixOrderSearch(id);
        }
        if (temp!=null){
            return temp;
        }
        if (this.id==id){
            return this;
        }
        if (this.right!=null){
            temp=this.right.infixOrderSearch(id);
        }
        return temp;
    }
    //后序遍历查找
    public Node postOrderSearch(int id){
       Node temp=null;
       if (this.left!=null){
           temp=this.left.postOrderSearch(id);
       }
       if (temp!=null){
           return temp;
       }
       if (this.right!=null){
           temp=this.right.postOrderSearch(id);
       }
       if (temp!=null){
           return temp;
       }
       if (this.id==id){
           return this;
       }
       return temp;
    }
}