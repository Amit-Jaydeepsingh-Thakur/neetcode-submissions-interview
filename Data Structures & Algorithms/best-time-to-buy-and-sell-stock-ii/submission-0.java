class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for (int i = 0 ; i < dp.length; i++) {
            for (int j = 0 ; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(0, 0, prices, dp);
    }

    private int solve(int i, int decision, int[] prices, int[][] dp) {
        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][decision] != -1) {
            return dp[i][decision];
        }

        int res = 0;
        res = solve(i + 1, decision, prices, dp);
        if (decision == 0) {
            int buy = -prices[i] + solve(i + 1,  1, prices, dp);
            res = Math.max(buy, res);
        } else {
            int sell = prices[i] + solve(i + 1, 0, prices, dp);
            res = Math.max(sell, res);
        }
        
        return dp[i][decision] = res;
    }
}