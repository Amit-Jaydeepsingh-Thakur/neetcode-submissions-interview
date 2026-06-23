class Solution {
    private int[] suffixSum;
    private Integer[][] dp;

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        suffixSum = new int[n + 1];
        dp = new Integer[n][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return solve(0, 1, piles);
    }

    private int solve(int start, int m, int[] piles) {
        if (start >= piles.length) {
            return 0;
        }

        if (dp[start][m] != null) {
            return dp[start][m];
        }

        int best = 0;

        for (int x = 1; x <= 2 * m && start + x <= piles.length; x++) {
            int opponent = solve(start + x, Math.max(m, x), piles);
            best = Math.max(best, suffixSum[start] - opponent);
        }

        return dp[start][m] = best;
    }
}