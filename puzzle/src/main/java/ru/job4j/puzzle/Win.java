package ru.job4j.puzzle;

public class Win {

    public static boolean check(int[][] board) {
        boolean resalt = false;
        for (int i = 0; i < board.length; i++) {
            resalt = checkHorizontal(board, i) || checkVertical(board, i);
            if (resalt) {
                break;
            }
        }
        return resalt;
    }

    public static boolean checkHorizontal(int[][] board, int row) {
        boolean result = true;
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean checkVertical(int[][] board, int column) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
