package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        return checkHorizontal(board) || checkVertical(board);
    }

    public static boolean checkHorizontal(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            int k = 0;
            for (int j = 0; j < board[i].length; j++) {
                k += board[i][j];
            }
            if (k == board[i].length) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static boolean checkVertical(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            int k = 0;
            for (int j = 0; j < board.length; j++) {
                k += board[j][i];
            }

            if (k == board.length) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

}
