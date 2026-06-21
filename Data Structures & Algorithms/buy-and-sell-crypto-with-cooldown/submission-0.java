class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, j = 0;
        int[][] dp = new int[prices.length + 1][3];

        for (i = 0; i < dp.length; i++) {
            for (j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 1, prices, dp);
    }

    private int solve(int i, int flag, int[] prices, int[][] dp) {
        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][flag] != -1) {
            return dp[i][flag];
        }

        int buy = 0, sell = 0;
        if (flag == 1) {
            buy = Math.max(-prices[i] + solve(i + 1, 0, prices, dp),
                            solve(i + 1, 1, prices, dp));
        } else {
            sell = Math.max(prices[i] + solve(i + 2, 1, prices, dp),
                            solve(i + 1, 0, prices, dp));
        }

        return dp[i][flag] = Math.max(buy, sell);
    }
}
