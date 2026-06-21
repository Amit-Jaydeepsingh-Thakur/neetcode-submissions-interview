class Solution {
    public int change(int amount, int[] coins) {
        int i = 0, j = 0;
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (i = 0; i < dp.length; i++) {
            for (j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, amount, coins, dp);
    }

    private int solve(int i, int amount, int[] coins, int[][] dp) {
        if (i == coins.length || amount < 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        int take = solve(i, amount - coins[i], coins, dp);
        int notTake = solve(i + 1, amount, coins, dp);

        return dp[i][amount] = take + notTake;
    }
}
