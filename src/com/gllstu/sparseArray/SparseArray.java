package com.gllstu.sparseArray;

/**
 * @author LinJun
 * @version 1.0
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] chess = new int[11][11];
        chess[1][2]=1;
        chess[2][3]=2;
        chess[4][9]=1;
        for (int[] ints :chess) {
            for (int data :ints) {
                System.out.print(data+" ");
            }
            System.out.println("\n");
        }
        //先遍历原数组，然后记录非0值
        int sum=0;
        for (int i=0;i<chess.length;i++){
            for (int j=0;j<chess[i].length;j++){
                if (chess[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0]=chess.length;
        sparseArr[0][1]=chess[0].length;
        sparseArr[0][2]=sum;
        //遍历二维数组，将非0值存放到稀疏数组中
        int temp=1;
        for (int i=0;i<chess.length;i++){
            for (int j=0;j<chess[i].length;j++){
                if (chess[i][j]!=0&&temp<=sum){
                    sparseArr[temp][0]=i;
                    sparseArr[temp][1]=j;
                    sparseArr[temp][2]=chess[i][j];
                    temp++;
                }
            }
        }
        for (int[] ints :sparseArr) {
            for (int data  :ints) {
                System.out.print(data+" ");
            }
            System.out.println("\n");
        }
        //还原稀疏数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i=1;i<sparseArr.length;i++){

                chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];

        }
        for (int[] ints :chessArr2) {
            for (int data  :ints) {
                System.out.print(data+" ");
            }
            System.out.println("\n");
        }

    }
}
