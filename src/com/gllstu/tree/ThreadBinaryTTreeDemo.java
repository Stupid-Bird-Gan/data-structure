package com.gllstu.tree;

/**
 * @author LinJun
 * @version 1.0
 */
public class ThreadBinaryTTreeDemo {
    public static void main(String[] args) {
        Node1 root = new Node1(1, "q");
        Node1 node1 = new Node1(3, "w");
        Node1 node2 = new Node1(6, "e");
        Node1 node3 = new Node1(8, "r");
        Node1 node4= new Node1(10, "t");
        Node1 node5= new Node1(14, "y");
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);

        ThreadBinaryTrees threadBinaryTrees = new ThreadBinaryTrees();
        threadBinaryTrees.setRoot(root);
        threadBinaryTrees.threadedNodes(root);
        Node1 left = node4.getLeft();
        System.out.println(left);
        threadBinaryTrees.threadList();
    }
}
class ThreadBinaryTrees{
    private Node1 root;
    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    private Node1 pre=null;
    public void setRoot(Node1 root) {
        this.root = root;
    }
    public void threadedNodes(){
        this.threadedNodes(root);
    }
    //编写对二叉树进行中序线索化的方法
    public void threadedNodes(Node1 root){
        if (root==null){
            return;
        }
        threadedNodes(root.getLeft());
        if (root.getLeft()==null){
            root.setLeft(pre);
            root.setLeftType(1);
        }
        if (pre!=null&&pre.getRight()==null){
            pre.setRight(root);
            pre.setRightType(1);
        }
        pre=root;
        threadedNodes(root.getRight());

    }
    //遍历线索化二叉树的方法
    public void threadList(){
        Node1 node=root;
        while (node!=null){
            while (node.getLeftType()==0){
                node=node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }


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
    public Node1 preOrderSearch(int id){
        if (root!=null){
            return root.preOrderSearch(id);
        }else {
            return null;
        }
    }
    //中序查找
    public Node1 infixOrderSearch(int id){
        if (root!=null){
            return root.infixOrderSearch(id);
        }else {
            return null;
        }
    }
    //后序查找找
    public Node1 postOrderSearch(int id){
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
class Node1{
    private int id;
    private String name;
    private Node1 left;
    private Node1 right;
    private int leftType;
    private int rightType;
    //如果leftType==0表示指向左子树，等于1就指向前驱
    //如果rightType==0表示指向右子树，等于1指向后继结点

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public Node1(int id, String name) {
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

    public Node1 getLeft() {
        return left;
    }

    public void setLeft(Node1 left) {
        this.left = left;
    }

    public Node1 getRight() {
        return right;
    }

    public void setRight(Node1 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node1{" +
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
    public Node1 preOrderSearch(int id){
        if (this.id==id){
            return this;
        }
        Node1 temp = null;
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
    public Node1 infixOrderSearch(int id){
        Node1 temp=null;
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
    public Node1 postOrderSearch(int id){
        Node1 temp=null;
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