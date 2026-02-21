package medium.p1__200.problem59;


import static org.junit.Assert.assertArrayEquals;

public class Solution59 {

    private static int[][] expected;

    public static int[][] generateMatrixTest(int n) {
        Solution59.Solution3 solution3 = new Solution59.Solution3();
        return solution3.generateMatrix(n);
    }

    public static void main(String[] args) {
        Solution59.Solution3 solution3 = new Solution59.Solution3();

        expected =
            new int[][] {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        assertArrayEquals(expected, solution3.generateMatrix(3));
        assertArrayEquals(expected, generateMatrixTest(3));

        expected =
            new int[][] {{1}};
        assertArrayEquals(expected, solution3.generateMatrix(1));
        assertArrayEquals(expected, generateMatrixTest(1));
    }

    public static class Solution1 {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            if (n == 0) {
                return matrix;
            }

            int value = 1;
            int top = 0;
            int bottom = n - 1;
            int left = 0;
            int right = n - 1;
            while (left <= right && top <= bottom) {
                for (int j = left; j <= right; j++) {
                    matrix[top][j] = value++;
                }
                top++;
                for (int i = top; i <= bottom; i++) {
                    matrix[i][right] = value++;
                }
                right--;
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = value++;
                }
                bottom--;
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = value++;
                }
                left++;
            }
            return matrix;
        }
    }

    public static class Solution2 {
        public int[][] generateMatrix(int n) {
            int direction = 0;
            int[][] matrix = new int[n][n];
            int num = 1;
            int i = 0;
            int j = 0;
            int eastBoundary = n;
            int southBoundary = n;
            int westBoundary = 0;
            int northBoundary = 0;
            int limit = n * n;
            while (num <= limit) {
                if (direction % 4 == 0) {
                    // 0 means going east
                    for (; j < eastBoundary && num <= limit; j++) {
                        matrix[i][j] = num;
                        num++;
                    }
                    j--;
                    direction++;
                    eastBoundary--;
                    i++;
                }
                if (direction % 4 == 1) {
                    // 1 means going south
                    for (; i < southBoundary && num <= limit; i++) {
                        matrix[i][j] = num;
                        num++;
                    }
                    i--;
                    direction++;
                    southBoundary--;
                    j--;
                }
                if (direction % 4 == 2) {
                    // 2 means going west
                    for (; j >= westBoundary && num <= limit; j--) {
                        matrix[i][j] = num;
                        num++;
                    }
                    j++;
                    direction++;
                    westBoundary++;
                    i--;
                }
                if (direction % 4 == 3) {
                    // 3 means going north
                    for (; i > northBoundary && num <= limit; i--) {
                        matrix[i][j] = num;
                        num++;
                    }
                    i++;
                    direction++;
                    northBoundary++;
                    j++;
                }
            }
            return matrix;
        }
    }

    public static class Solution3 {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            int i = 0, j = 0, k = 0;
            int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int v = 1; v <= n * n; ++v) {
                ans[i][j] = v;
                int x = i + dirs[k][0], y = j + dirs[k][1];
                if (x < 0 || y < 0 || x >= n || y >= n || ans[x][y] > 0) {
                    k = (k + 1) % 4;
                    x = i + dirs[k][0];
                    y = j + dirs[k][1];
                }
                i = x;
                j = y;
            }
            return ans;
        }
    }
}
