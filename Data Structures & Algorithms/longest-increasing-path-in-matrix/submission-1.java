class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int i = 0, j = 0, max = Integer.MIN_VALUE;
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        int[][] dp = new int[vis.length][vis[0].length];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (i = 0 ; i < matrix.length; i++) {
            for (j = 0 ; j < matrix[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        for (i = 0 ; i < matrix.length; i++) {
            for (j = 0 ; j < matrix[0].length; j++) {
                max = Math.max(max, solve(i, j, Integer.MIN_VALUE, matrix, dp, dirs));
                //System.out.println("==" + " " + max);
            }
        }

        return max;
    }

    private int solve(int i, int j, int prev, int[][] matrix, int[][] dp, int[][] dirs) {
        if (i < 0 || j < 0 || i >= matrix.length 
            || j >= matrix[0].length
            || matrix[i][j] <= prev) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        //System.out.println(matrix[i][j] + " " + prev);

        //vis[i][j] = true;

        int ans = 1;

        for (int[] dir : dirs) {
            ans = Math.max(ans, 1 + solve(i + dir[0], j + dir[1], matrix[i][j], matrix, dp, dirs));
        }

        // int ans = 1 + solve(i + 1, j, matrix[i][j], matrix, vis)
        //             + solve(i - 1, j, matrix[i][j], matrix, vis)
        //             + solve(i, j + 1, matrix[i][j], matrix, vis)
        //             + solve(i, j - 1, matrix[i][j], matrix, vis);

        //vis[i][j] = false;

        return dp[i][j] = ans;


    }
}
