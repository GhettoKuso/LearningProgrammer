package com.wei.ds;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] arr = generateArr(7, 6);
        System.out.println("--------OriginalArr--------");
        printArr(arr);
        int[][] sparseArr = transToSparseArr(arr);
        System.out.println("--------SparseArr--------");
        printArr(sparseArr);
        System.out.println("--------BackArr--------");
        int[][] result = backToArr(sparseArr);
        printArr(result);
    }

    /**
     * <p>用于生成一个二维数组</p>
     *
     * @param row 行数
     * @param col 列数
     * @return int[][]
     * @version 0.1.0
     * @author SunWei
     * @date 2020/6/18 12:52
     * @since 0.1.0
     */
    public static int[][] generateArr(int row, int col) {
        int[][] arr = new int[row][col];
        arr[0][0] = 5;
        arr[row - 1][col - 1] = 10;
        arr[row - 1][0] = 15;
        arr[0][col - 1] = 25;
        return arr;
    }

    /**
     * <p>用于将一个无用数据远多于有用数据的数组转换成稀疏数组</p>
     *
     * @param arr 需要转换的数组
     * @return int[][]
     * @version 0.1.0
     * @author SunWei
     * @date 2020/6/18 12:58
     * @since 0.1.0
     */
    public static int[][] transToSparseArr(int[][] arr) {
        int[][] sparseArr = new int[arr.length * arr[0].length][3];
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        int useful = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    useful++;
                    sparseArr[useful][0] = i;
                    sparseArr[useful][1] = j;
                    sparseArr[useful][2] = arr[i][j];
                }
            }
        }
        sparseArr[0][2] = useful;
        return handleUsefulArr(sparseArr);
    }

    /**
     * <p>打印数组结构</p>
     *
     * @param arr arr
     * @return void
     * @version 0.1.0
     * @author SunWei
     * @date 2020/6/18 13:00
     * @since 0.1.0
     */
    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * <p>处理稀疏数组无用的数据</p>
     *
     * @param arr arr
     * @return int[][]
     * @version 0.1.0
     * @author SunWei
     * @date 2020/6/18 13:34
     * @since 0.1.0
     */
    public static int[][] handleUsefulArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == arr[i].length - 1 && arr[i][j] == 0) {
                    return Arrays.copyOf(arr, i);
                }
            }
        }
        return null;
    }

    /**
     * <p>稀疏数组转二维数组</p>
     * @param arr arr
     * @version 0.1.0
     * @return int[][]
     * @author SunWei
     * @date 2020/6/18 17:58
     * @since 0.1.0
    */
    public static int[][] backToArr(int[][] arr){
        int row = arr[0][0];
        int col = arr[0][1];
        int [][] result = new int[row][col];
        for (int i = 1; i < arr.length; i++) {
            int useRow = arr[i][0];
            int useCol = arr[i][1];
            int value = arr[i][2];
            result[useRow][useCol] = value;
        }
        return result;
    }
}
