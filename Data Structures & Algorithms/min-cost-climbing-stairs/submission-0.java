class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        Arrays.fill(dp, Integer.MAX_VALUE);

        return Math.min(solve(0, cost, dp), solve(1, cost, dp));
    }

    private int solve(int n, int[] cost, int[] dp) {
        if (n >= cost.length) {
            return 0;
        }

        if (dp[n] != Integer.MAX_VALUE) {
            return dp[n];
        }

        if (n == cost.length - 1) {
            return cost[n];
        }

        return dp[n] = cost[n] + Math.min(solve(n + 1, cost, dp), solve(n + 2, cost, dp));
    }
}
