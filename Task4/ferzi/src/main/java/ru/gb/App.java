package ru.gb;

/**
 * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 *
 */

import java.util.Arrays;

public class App {
    public static void main (String[] args) {
        
        int N = 8; 
        char[][] mat = new char[N][N]; 
 
        for (int i = 0; i < N; i++) { 
            Arrays.fill(mat[i], 'х');
        }
 
        findingSolution(mat, 0); 
        
    }
    
    private static boolean securityCheck (char[][] mat, int r, int c) {
        
        for (int i = 0; i < r; i++) {
            if (mat[i][c] == 'Ф') {
                return false; 
            }
        }
 
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 'Ф') {
                return false; 
            }
        }
 
        for (int i = r, j = c; i >= 0 && j < mat.length; i--, j++) {
            if (mat[i][j] == 'Ф') {
                return false; 
            }
        }

        return true; 
    }

    private static void printSolution (char[][] mat) {
        for (char[] chars : mat) {
            System.out.println(Arrays.toString(chars).replaceAll(",", ""));
        }
        System.out.println();
    }

    private static void findingSolution (char[][] mat, int r) {
        
        if (r == mat.length) { 
            printSolution(mat);
        }
        
        for (int i = 0; i < mat.length; i++) { 
            if (securityCheck(mat, r, i)) {             
                mat[r][i] = 'Ф'; 
                findingSolution (mat, r + 1); 
                mat[r][i] = 'х';
            }
        }
    }
}