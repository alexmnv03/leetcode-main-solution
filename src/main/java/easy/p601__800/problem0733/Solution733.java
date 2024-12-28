package easy.p601__800.problem0733;

public class Solution733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        search(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void search(
            int[][] image,
            int row, // номер новой строки
            int col, // номер нового столбца
            int initColor,
            int newColor
    ) {
        if (row >= image.length // номер строки выходит за границы 1 массива (кол-во строк)
                || col >= image[0].length // номер столбца выходит за границы 2 массива (столбцов)
                || row < 0  // номер строки выходит за границы 1 массива
                || col < 0  // номер столбца выходит за границы 2 массива
                || image[row][col] == newColor // если новая ячейка уже имеет новый цвет
                || image[row][col] != initColor // если новая ячейка не равна исходному цвету
        )
            return;
        // Если все условия выполнены, то присваиваем яцеке новый цвет
        image[row][col] = newColor;
        // Перемещаемся относительно текущей ячейки во все четыре стороны
        search(image,row + 1, col, initColor, newColor);
        search(image,row - 1, col, initColor, newColor);
        search(image,row, col + 1, initColor, newColor);
        search(image,row, col - 1, initColor, newColor);
    }
}
