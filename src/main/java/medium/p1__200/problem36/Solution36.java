package medium.p1__200.problem36;

import static org.junit.Assert.assertEquals;

import medium.p1__200.problem33.Solution33;

public class Solution36 {

    private static char[][] board;

    public static boolean isValidSudokuTest(char[][] board) {
        Solution36.Solution2 solution2 = new Solution36.Solution2();
        return solution2.isValidSudoku(board);
    }

    public static void main(String[] args) {
        Solution36.Solution2 solution2 = new Solution36.Solution2();

        board =
            new char[][] {
                {'4', '3', '5', '2', '6', '9', '7', '8', '1'},
                {'6', '8', '2', '5', '7', '1', '4', '9', '3'},
                {'1', '9', '7', '8', '3', '4', '5', '6', '2'},
                {'8', '2', '6', '1', '9', '5', '3', '4', '7'},
                {'3', '7', '4', '6', '8', '2', '9', '1', '5'},
                {'9', '5', '1', '7', '4', '3', '6', '2', '8'},
                {'5', '1', '9', '3', '2', '6', '8', '7', '4'},
                {'2', '4', '8', '9', '5', '7', '1', '3', '6'},
                {'7', '6', '3', '4', '1', '8', '2', '5', '9'},
            };
        assertEquals(true, solution2.isValidSudoku(board));
        assertEquals(true, isValidSudokuTest(board));

        board =
            new char[][] {
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'},
            };
        assertEquals(true, solution2.isValidSudoku(board));
        assertEquals(true, isValidSudokuTest(board));

        board =
            new char[][] {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                // this upper right corner 3*3 square is invalid, '1' appears twice
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'},
            };
        assertEquals(false, solution2.isValidSudoku(board));
        assertEquals(false, isValidSudokuTest(board));

        board =
            new char[][] {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
            };
        assertEquals(false, solution2.isValidSudoku(board));
        assertEquals(false, isValidSudokuTest(board));
    }

    public static class Solution1 {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                if (!isValidRowOrColumn(board, i)) {
                    return false;
                }
            }

            for (int j = 0; j < 9; j++) {
                if (!isValidCol(board, j)) {
                    return false;
                }
            }

            for (int i = 0; i < 7; i = i + 3) {
                for (int j = 0; j < 7; j = j + 3) {
                    if (!isValidSquare(board, i, j)) {
                        return false;
                    }
                }
            }
            return true;
        }

        boolean isValidRowOrColumn(char[][] board, int index) {
            int[] nums = new int[9];
            for (int i = 0; i < 9; i++) {
                nums[i] = 1;
            }
            for (int j = 0; j < 9; j++) {
                if (board[index][j] != '.') {
                    nums[Character.getNumericValue(board[index][j]) - 1]--;
                }
            }
            for (int i : nums) {
                if (i < 0) {
                    return false;
                }
            }
            return true;
        }

        boolean isValidCol(char[][] board, int col) {
            int[] nums = new int[9];
            for (int i = 0; i < 9; i++) {
                nums[i] = 1;
            }
            for (int i = 0; i < 9; i++) {
                if (board[i][col] != '.') {
                    nums[Character.getNumericValue(board[i][col]) - 1]--;
                }
            }
            for (int i : nums) {
                if (i < 0) {
                    return false;
                }
            }
            return true;
        }

        boolean isValidSquare(char[][] board, int row, int col) {
            int[] nums = new int[9];
            for (int i = 0; i < 9; i++) {
                nums[i] = 1;
            }
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    if (board[i][j] != '.') {
                        nums[Character.getNumericValue(board[i][j]) - 1]--;
                    }
                }
            }
            for (int i : nums) {
                if (i < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class Solution2 {
        public boolean isValidSudoku(char[][] board) {
            boolean[][] row = new boolean[9][9];
            boolean[][] col = new boolean[9][9];
            boolean[][] sub = new boolean[9][9];
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    char c = board[i][j];
                    if (c == '.') {
                        continue;
                    }
                    int num = c - '0' - 1;
                    int k = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || sub[k][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    sub[k][num] = true;
                }
            }
            return true;
        }
    }
}
