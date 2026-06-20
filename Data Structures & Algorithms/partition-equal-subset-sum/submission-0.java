class Solution {
    public boolean canPartition(int[] nums) {
        int i = 0, j = 0, sum = 0;

        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        boolean[][] vis = new boolean[nums.length + 1][sum + 1];
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];

        // for (i = 0; i < dp.length; i++) {
        //     for (j = 0; j < dp[0].length; j++) {
        //         dp[i][j] = -1;
        //     }
        // }

        if (sum % 2 != 0) {
            return false;
        }

        return solve(0, sum / 2, nums, dp, vis);
    }

    private boolean solve(int idx, int target, int[] nums, boolean[][] dp, boolean[][] vis) {
        if (idx >= nums.length || target < 0) {
            return false;
        }

        if (target == 0) {
            return true;
        }

        if (vis[idx][target]) {
            return dp[idx][target];
        }

        vis[idx][target] = true;

        boolean take = solve(idx + 1, target - nums[idx], nums, dp, vis);
        boolean notTake = solve(idx + 1, target, nums, dp, vis);

        return dp[idx][target] = take || notTake;


    }
}
