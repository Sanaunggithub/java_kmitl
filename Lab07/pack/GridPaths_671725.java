package pack;

public class GridPaths_671725 {
    public int numberOfPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // start cell
        dp[0][0] = (grid[0][0] == 0) ? 1 : 0;

        // first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = (grid[i][0] == 0) ? dp[i-1][0] : 0;
        }

        // first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = (grid[0][j] == 0) ? dp[0][j-1] : 0;
        }

        // fill rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) dp[i][j] = 0; // obstacle
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

}
