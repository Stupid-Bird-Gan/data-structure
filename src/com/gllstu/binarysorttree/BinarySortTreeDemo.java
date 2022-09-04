package com.gllstu.binarysorttree;

/**
 * @author LinJun
 * @version 1.0
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr={7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i=0;i< arr.length;i++){
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
//        binarySortTree.delNode(2);
//        binarySortTree.delNode(5);
//        binarySortTree.delNode(9);
//        binarySortTree.delNode(12);
        binarySortTree.delNode(1);
        binarySortTree.delNode(10);
        binarySortTree.infixOrder();
    }
}
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
    //添加结点的方法
    public void add(Node node){
        if (node==null){
            return;
        }
        //判断传入结点的值和当前子树的根结点的关系
        if (node.data<this.data){
            if (this.left==null){
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
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
}
//创建二叉排序树
class BinarySortTree{
    private Node root;
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
    //编写一个方法返回右子树的最小子结点

    /**
     *
     * @param node 当作根结点
     * @return 返回最小结点的值
     * 而且还要删除最小结点
     */
    public int delRightTerrMin(Node node){
        Node target=node;
        while (target.left!=null){
            target=target.left;
        }
        int data=target.data;
        delNode(target.data);
        return data;
    }
    //删除结点
    public void delNode(int data){
        if (root==null){
            return;
        }else {
            Node target = search(data);
            if (target==null){
                return;
            }
            //如果target是root
            if (root.left==null&&root.right==null){
                root =null;
                return;
            }
            Node parent = searchParent(data);
            if (target.left==null&&target.right==null){
                if (parent.left!=null&&parent.left==target){
                    parent.left=null;
                }else if (parent.right!=null&&parent.right==target){
                    parent.right=null;
                }
            }else if (target.left!=null&&target.right!=null){
                int temp = delRightTerrMin(target.right);
                target.data=temp;

            }else {
                //如果有左子节点
                if (target.left!=null) {
                    if (parent != null) {
                        if (parent.left == target) {
                            parent.left = target.left;
                        } else {
                            parent.right = target.left;
                        }
                    }else {
                        root=target.left;
                    }
                }else {
                    if (parent != null) {
                        if (parent.left == target) {
                            parent.left = target.right;
                        } else {
                            parent.right = target.right;
                        }
                    }else {
                        root=target.right;
                    }
                }
            }
        }
    }
}