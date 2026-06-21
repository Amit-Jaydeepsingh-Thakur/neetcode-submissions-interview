class Solution {
    public int minPathSum(int[][] grid) {
        int i = 0, j = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int[][] dp = new int[grid.length][grid[0].length];

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, grid, vis, dp);
    }

    private int solve(int i, int j, int[][] grid, boolean[][] vis, int[][] dp) {
        if (i < 0 || j < 0 || i >= grid.length 
            || j >= grid[0].length || vis[i][j]) {
            return Integer.MAX_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        vis[i][j] = true;

        int ans = grid[i][j] + Math.min(solve(i + 1, j, grid, vis, dp), solve(i, j + 1, grid, vis, dp));
        vis[i][j] = false;

        return dp[i][j] = ans;

    } 
}