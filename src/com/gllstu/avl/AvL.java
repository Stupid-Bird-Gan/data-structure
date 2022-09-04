package com.gllstu.avl;

/**
 * @author LinJun
 * @version 1.0
 */
public class AvL {
    public static void main(String[] args) {
        //int[] arr={4,3,6,5,7,8};
        int[] arr={10,12,8,9,7,6};

        AvlTree avlTree = new AvlTree();
        for (int i=0;i<arr.length;i++){
            avlTree.add(new Node(arr[i]));
        }
        avlTree.infixOrder();
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());
    }
}
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    //添加结点的方法
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入结点的值和当前子树的根结点的关系
        if (node.data < this.data) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        //当添加完一个结点后，如果发现右子树的高度-左子树的高度大于1，就进行左旋转
        if (this.rightHeight()-this.leftHeight()>1){
            //先判断当前结点的右子节点的左子节点高度是否大于右子节点
            if(this.right!=null&&this.right.rightHeight()<this.right.leftHeight()){
                //先进行左子树的左旋转
                this.right.rightRotate();
            }
            this.leftRotate();
            return;
        }
        if (this.leftHeight()-this.rightHeight()>1){
            //先判断当前结点的右子节点的高度是否大于左子节点
            if(this.left!=null&&this.left.rightHeight()>this.left.leftHeight()){
                //先进行左子树的左旋转
                this.left.leftRotate();
            }
            this.rightRotate();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
    //返回以该节点为根节点的树的高度
    public int height(){
        return Math.max(left==null?0:left.height(), right==null?0: right.height())+1;
    }
    //返回左子树的高度
    public int leftHeight(){
        if (left==null){
            return 0;
        }
        return left.height();
    }
    //返回右子树的高度
    public int rightHeight(){
        if (right==null){
            return 0;
        }
        return right.height();
    }
    //查找要删除的结点
    public Node search(int data){
        if (data==this.data){
            return this;
        }else if (data<this.data){
            if (this.left==null){
                return null;
            }
            return this.left.search(data);
        }else {
            if (this.right==null){
                return null;
            }
            return this.right.search(data);
        }
    }
    //返回待删除结点的父节点
    public Node searchParent(int data){
        if ((this.left!=null&&this.left.data==data)||(this.right!=null&&this.right.data==data)){
            return this;
        }else {
            if (this.data>data&&this.left!=null){
                return this.left.searchParent(data);
            }else if(data>=this.data&&this.right!=null) {
                return this.right.searchParent(data);
            }else {
                return null;
            }
        }
    }
    //左旋转
    public void leftRotate(){
        Node newNode = new Node(this.data);
        newNode.left=this.left;
        newNode.right=this.right.left;
        this.data=this.right.data;
        this.right=this.right.right;
        this.left=newNode;
    }
    //右旋转
    public void rightRotate(){
        Node newNode = new Node(this.data);
        newNode.right=this.right;
        newNode.left=this.left.right;
        this.data=this.left.data;
        this.left=this.left.left;
        this.right=newNode;
    }
}
class AvlTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(Node node){
        if (root==null){
            root=node;
        }else {
            root.add(node);
        }
    }
    //中序遍历
    public void infixOrder(){
        if (root==null){
            System.out.println("null");
        }else {
            root.infixOrder();
        }
    }
    //查找目标结点
    public Node search(int data){
        if (root==null){
            return null;
        }else {
            return root.search(data);
        }
    }
    //查找目标父节点
    public Node searchParent(int data){
        if (root==null){
            return null;
        }else {
            return root.searchParent(data);
        }
    }
    //左旋转

}