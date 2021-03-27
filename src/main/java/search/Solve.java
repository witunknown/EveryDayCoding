package search;

/**
 * @author Sun
 * @version 1.0.0
 * @ClassName Solve.java
 * @Description :给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
 * @createTime 2021年03月25日 22:16:00
 */
public class Solve {

    public static void main(String[] args) {
        char[][] aa = new char[][]{{'1'}};

        System.out.println(solve(aa));

    }


    public static int solve(char[][] grid) {

        if (null == grid || grid.length == 0) {
            return 0;
        }

        int width = grid.length;
        int length = grid[0].length;
        int size = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == '1') {
                    searchDao(grid, i, j, width, length);
                    size++;
                }
            }
        }

        return size;
    }

    private static void searchDao(char[][] grid, int i, int j, int width, int length) {
        if (i >= 0 && j >= 0 && i < width && j < length) {
            if (grid[i][j] == '1') {
                grid[i][j] = '0';
                searchDao(grid, i - 1, j, width, length);
                searchDao(grid, i + 1, j, width, length);
                searchDao(grid, i, j - 1, width, length);
                searchDao(grid, i, j + 1, width, length);
            }
        }
    }
}
