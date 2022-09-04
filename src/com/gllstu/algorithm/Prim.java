package com.gllstu.algorithm;

import java.util.Arrays;

/**
 * @author LinJun
 * @version 1.0
 */
public class Prim {
    public static void main(String[] args) {
        char data[] = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertx = data.length;
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        MGraph mGraph = new MGraph(vertx);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,vertx,data,weight);
        minTree.showGraph(mGraph);
        minTree.prim(mGraph,0);
    }
}
class MGraph{
    int vertx;
    char[] data;
    int[][] weight;
    public MGraph(int vertx){
        this.vertx=vertx;
        data=new char[vertx];
        weight=new int[vertx][vertx];
    }
}
//创建最小生成树
class MinTree{
    /**
     *
     * @param mGraph 图对象
     * @param vertx 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph mGraph,int vertx,char[] data,int[][] weight){
        int i,j;
        for (i=0;i<vertx;i++){
            mGraph.data[i]=data[i];
            for (j=0;j<vertx;j++){
                mGraph.weight[i][j]=weight[i][j];
            }
        }
    }
    //显示图的邻接矩阵
    public void showGraph(MGraph mGraph){
        for (int[] ints: mGraph.weight){
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     *
     * @param mGraph 表示图
     * @param v 表示从图的第几个顶点开始生成'A'->0,'B'->1....
     */
    public void prim(MGraph mGraph,int v){
        int[] visited = new int[mGraph.vertx];//标记顶点是否被访问过
//        for (int i=0;i<mGraph.vertx;i++){
//            visited[i]=0;
//        }
        //把当前的结点标记为1
        visited[v]=1;
        int h1=-1;
        int h2=-1;
        int minWeight=10000;
        for (int i=1;i<mGraph.vertx;i++){
            for (int j=0;j<mGraph.vertx;j++){
                for (int k=0;k< mGraph.vertx;k++){
                    if (visited[j]==1&&visited[k]==0&&mGraph.weight[j][k]<minWeight){
                        minWeight=mGraph.weight[j][k];
                        h1=j;
                        h2=k;
                    }
                }
            }
            System.out.println("边"+mGraph.data[h1]+","+mGraph.data[h2]+">权值："+minWeight);
            visited[h2]=1;
            minWeight=10000;
        }
    }
}
