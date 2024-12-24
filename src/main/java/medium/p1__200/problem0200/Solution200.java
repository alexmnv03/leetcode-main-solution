package medium.p1__200.problem0200;

public class Solution200 {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // нашлю землю - теперь заполним весь остров цветом 2
                    fillNewColor(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void fillNewColor(char[][] grid, int row, int col){
        if (row >= grid.length // номер строки выходит за границы 1 массива (кол-во строк)
                || row < 0  // номер строки выходит за границы 1 массива
                || col >= grid[row].length // номер столбца выходит за границы 2 массива (столбцов)
                || col < 0  // номер столбца выходит за границы 2 массива
                || grid[row][col] != '1' // если новая ячейка не земля
        )
            return;
        grid[row][col] = '2';
        // Перемещаемся относительно текущей ячейки во все четыре стороны
        fillNewColor(grid, row + 1, col);
        fillNewColor(grid, row - 1, col);
        fillNewColor(grid, row, col + 1);
        fillNewColor(grid, row, col - 1);
    }

}
