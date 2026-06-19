class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        if (n < 0) {
            return 0;
        }

        if (dp[n] != Integer.MAX_VALUE) {
            return dp[n];
        }

        if (n == 0) {
            return 1;
        }

        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    }
}
