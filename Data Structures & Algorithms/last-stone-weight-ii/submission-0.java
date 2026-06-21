class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;

        for (Integer ele : stones) {
            sum += ele;
        }

        int target = (sum + 1) / 2;

        int[][] dp = new int[stones.length + 1][sum + 5];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, stones, dp, sum, target);
    }

    private int solve(int i, int total, int[] stones, int[][] dp, int sum, int target) {
        if (total >= target || i == stones.length) {
            return Math.abs(total - (sum - total));
        }

        if (dp[i][total] != -1) {
            return dp[i][total];
        }

        return dp[i][total] = Math.min(solve(i + 1, total, stones, dp, sum, target),
                        solve(i + 1, total + stones[i], stones, dp, sum, target));
    }
}