package com.gllstu.algorithm;

import java.util.Arrays;

/**
 * @author LinJun
 * @version 1.0
 */
public class KruskalCase {
    public static void main(String[] args) {
        char[] vertx= {'A','B','C','D','E','F','G'};
        int[][] matrix={
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0},
        };
        KruskalCase kruskalCase = new KruskalCase(vertx, matrix);
        kruskalCase.print();
        EData[] edges = kruskalCase.getEdges();
        kruskalCase.sort(edges);
        System.out.println(Arrays.toString(edges));
        kruskalCase.kruskal();
    }
    private int edgeNum;//边数
    private char[] vertx;//顶点
    private int[][] matrix;//邻接矩阵
    private static final int INF = Integer.MAX_VALUE;
    public KruskalCase(char[] vertx,int[][]matrix){
        int vLen = vertx.length;
        this.vertx=vertx;
        this.matrix=matrix;
        //统计边
        for (int i=0;i<vLen;i++){
            for (int j=i+1;j<vLen;j++){
                if (this.matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }
    }
    //打印邻接矩阵
    public void print(){
        for (int[] ints :matrix) {
            System.out.println(Arrays.toString(ints));
        }

    }

    /**
     *
     * @param ch 顶点的值
     * @return 返回顶点对应的下标，如果找不到，返回-1
     */
    private int getPosition(char ch){
        for (int i=0;i<vertx.length;i++){
            if (vertx[i]==ch){
                return i;
            }
        }
        return -1;
    }
    //获取图中的边放到EData中，后续会遍历边
    private EData[] getEdges(){
        int index=0;
        EData[] edges = new EData[edgeNum];
        for (int i=0;i<vertx.length;i++){
            for (int j=i+1;j< vertx.length;j++){
                if (matrix[i][j]!=INF){
                    edges[index++]=new EData(vertx[i],vertx[j],matrix[i][j] );
                }
            }
        }
        return edges;
    }
    //对边进行排序
    public void sort(EData[] eData){
        for (int i=0;i<eData.length-1;i++){
            for (int j=0;j<eData.length-i-1;j++){
                if (eData[j].weight > eData[j+1].weight) {
                    EData temp = eData[j];
                    eData[j] = eData[j + 1];
                    eData[j + 1] = temp;
                }
            }
        }
    }
    //获取下标i的顶点的终点，用于后面判断的终点是否相同
    private int getEnd(int[] ends,int i){
        while (ends[i]!=0){
            i=ends[i];
        }
        return i;
    }
    public void kruskal(){
        int index=0;
        int []ends = new int[edgeNum];//用于保存已有最小生成树中的每个顶点的终点
        EData[] rets = new EData[edgeNum];
        //获取图中所有的边
        EData[] edges = getEdges();
        sort(edges);
        //遍历边，开始生成最小生成树,还要判断加入的边是否构成回路
        for (int i=0;i<edges.length;i++){
            int p1=getPosition(edges[i].start);
            int p2=getPosition(edges[i].end);
            int m=getEnd(ends,p1);
            int n=getEnd(ends,p2);
            if (m!=n){
                ends[m]=n;
                rets[index++]=edges[i];
            }
        }
        //输出rets
        System.out.println("最小生成树为"+Arrays.toString(rets));
    }
}
class EData{
    char start;//边的起点
    char end;//边的末点
    int weight;
    public EData(char start,char end,int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }

}