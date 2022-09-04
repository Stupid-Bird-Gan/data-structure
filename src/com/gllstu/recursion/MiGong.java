package com.gllstu.recursion;

/**
 * @author LinJun
 * @version 1.0
 */
public class MiGong {
    public static void main(String[] args) {
        //创建一个数组模拟迷宫
        int[][] map = new int[8][7];
        //1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        setWay(map,1,1);
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[i].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean setWay(int[][] map,int i,int j) {
        //到map[6][5]位置表示路找到
        //0表示没有走过
        //1表示墙
        //2表示已经走过
        //3表示该点走不通
        //在走迷宫时，策略为下右上左，走不通就回溯
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
