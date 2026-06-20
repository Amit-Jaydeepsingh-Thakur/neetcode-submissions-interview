class Solution {
    public int uniquePaths(int m, int n) {
        int i = 0, j = 0;

        int[][] grid = new int[m][n];
        int[][] dp = new int[m][n];

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                grid[i][j] = 0;
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, dp, grid);
    }

    private int solve(int i, int j, int[][] dp, int[][] grid) {
        if (i < 0 || j < 0|| i >= grid.length || j >= grid[0].length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }

        return dp[i][j] = solve(i + 1, j, dp, grid) + solve(i, j + 1, dp, grid);


    }
}
