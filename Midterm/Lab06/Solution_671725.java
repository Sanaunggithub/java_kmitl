import java.util.Queue;

public class Solution_671725 {
    public int maxLandArea(int[][] grid) {
        int max = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Loop through every cell in grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int area = bfs(grid, visited, r, c);
                    max = Math.max(max, area);
                }
            }
        }
        return max; 
    }


    private int bfs(int[][] grid, boolean[][] visited, int startR, int startC) {
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int count = 0;


        Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            count++;

            // Check 4 directions
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (isValid(grid, visited, nr, nc)) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        return count;  
    }


    private boolean isValid(int[][] grid, boolean[][] visited, int r, int c) {
        return r >= 0 && r < grid.length &&
        c >= 0 && c < grid[0].length &&
        grid[r][c] == 1 && !visited[r][c];
    }
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0},
            {1, 0, 0, 1},
            {0, 0, 1, 1},
            {1, 1, 0, 0}
        };
        Solution_671725 s = new Solution_671725();
        int result = s.maxLandArea(grid);
        System.out.println("Largest land area: " + result);
    }
}
