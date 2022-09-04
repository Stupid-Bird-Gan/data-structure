package com.gllstu.graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author LinJun
 * @version 1.0
 */
public class Graph {
    public static void main(String[] args) {
        int n=5;
        String vertexValue[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String value:vertexValue){
            graph.insert(value);
        }
        //添加边
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,1);
        graph.show();
        //graph.dfs();
        graph.bfs();
    }
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int nums;//表示边的个数
    //定义boolean数组，记录某个结点是否被访问
    private boolean[] isVisited ;
    public Graph(int n){
        edges=new int[n][n];
        vertexList=new ArrayList<>(n);
        isVisited = new boolean[n];
    }
    //插入顶点
    public void insert(String vertex){
        vertexList.add(vertex);
    }
    //添加边

    /**
     *
     * @param v1 表示第几个顶点
     * @param v2 表示第几个顶点
     * @param weight 表示边的权值
     */
    public void addEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        nums++;
    }
    //返回顶点的个数
    public int getNumsOfVertex(){
        return vertexList.size();
    }
    //返回边的数目
    public int getNums(){
        return nums;
    }
    //返回结点i的对应的数据
    public String getValue(int i){
        return vertexList.get(i);
    }
    //返回v1 v2的边的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //显示图对应的举证
    public void show(){
        for (int[] ints :edges) {
            for (int i :ints) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    //深度遍历

    //得到第一个邻接结点的下标
    public int getFirstNeighbor(int index){
        for (int i=0;i<vertexList.size();i++){
            if (edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }
    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
        for (int i=v2+1;i<vertexList.size();i++){
            if (edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }
    //深度优先遍历
    public void dfs(boolean[] isVisited,int i){
        //首先访问该节点，然后输出
        System.out.print(getValue(i)+"->");
        isVisited[i]=true;
        int w=getFirstNeighbor(i);
        while(w!=-1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            w=getNextNeighbor(i,w);
        }
    }
    //对dfs进行一个重载，遍历我们所有的结点，并进行dfs
    public void dfs(){
        //遍历所有的结点进行dfs
        for (int i=0;i<getNumsOfVertex();i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }
    //对一个结点进行广度优先遍历
    public void bfs(boolean[] isVisited,int i){
        int u;//表示队列头节点对应的下标
        int w;
        LinkedList<Object> list = new LinkedList<>();
        System.out.print(getValue(i)+"->");
        isVisited[i] = true;
        list.addLast(i);
        while (!list.isEmpty()){
            u=(Integer) list.removeFirst();
            w=getFirstNeighbor(u);
            while (w!=-1){
                if (!isVisited[w]){
                    System.out.print(getValue(w)+"->");
                    isVisited[w]=true;
                    list.addLast(w);
                }
                w=getNextNeighbor(u,w);
            }
        }
    }
    //广度优先遍历
    public void bfs(){
        for (int i=0;i<getNumsOfVertex();i++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }
}
