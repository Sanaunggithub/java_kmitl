package pack;

public class GridPaths_671725 {

    public int numberOfPaths(int[][] grid) {
        int m = grid.length; // row 
        int n = grid[0].length; // col

        Integer[][] memo = new Integer[m][n];

        return countPaths(grid, 0, 0, memo);
    }

    private int countPaths(int[][] grid, int i, int j, Integer[][] memo) {
        int m = grid.length;
        int n = grid[0].length;

        // Out of bounds
        if (i >= m || j >= n) return 0;

        // Obstacle cell
        if (grid[i][j] == 1) return 0;

        // Reached destination
        if (i == m - 1 && j == n - 1) return 1;

        // Check memo
        if (memo[i][j] != null) return memo[i][j];

        // Move right and down
        int paths = countPaths(grid, i + 1, j, memo) + countPaths(grid, i, j + 1, memo);

        // Save result in memo
        memo[i][j] = paths;

        return paths;
    }
}
