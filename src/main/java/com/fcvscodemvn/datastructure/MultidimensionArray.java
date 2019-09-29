package com.fcvscodemvn.datastructure;

public class MultidimensionArray {
    public static void main(String[] args) {
        int[][] a2d = new int[3][4];
        System.out.println(a2d);

        String[][][] a3d = new String[3][4][2];
        System.out.println(a3d);

        int[][] a2dinit = { { 1, 2, 3 }, { 4, 5, 6, 9 }, { 7 }, };

        System.out.println(a2dinit);
    }
}
