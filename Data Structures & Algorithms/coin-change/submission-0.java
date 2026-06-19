class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        int ans = solve(0, amount, coins, dp); 

        if (ans == Integer.MAX_VALUE - 1 || ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
        
    }

    private int solve(int i, int target, int[] amount, int[][] dp) {
        if (i >= amount.length || target < 0) {
            return Integer.MAX_VALUE - 1;
        }

        if (target == 0) {
            return 0;
        }

        if (dp[i][target] != Integer.MAX_VALUE) {
            return dp[i][target];
        }

        int take = 1 + solve(i, target - amount[i], amount, dp);
        int notTake = solve(i + 1, target, amount, dp);

        return dp[i][target] = Math.min(take, notTake);
    }
}
