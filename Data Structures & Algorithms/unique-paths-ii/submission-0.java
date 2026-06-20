class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i = 0, j = 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (i = 0 ; i < dp.length; i++) {
            for (j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, dp, obstacleGrid);
    }

    private int solve(int i, int j, int[][] dp, int[][] grid) {
        if (i < 0 || j < 0 || i >= dp.length || j >= dp[0].length || grid[i][j] != 0) {
            return 0;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = solve(i + 1, j, dp, grid) 
                        + solve(i, j + 1, dp, grid);
    }
}