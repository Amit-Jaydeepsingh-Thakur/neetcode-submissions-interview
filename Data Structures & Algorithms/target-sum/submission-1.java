class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int i = 0, j = 0, totSum = 0;

        for (i = 0; i < nums.length; i++) {
            totSum += nums[i];
        }

        int[][] dp = new int[nums.length + 1][2 * totSum + 1];

        for (i = 0 ; i < dp.length; i++) {
            for (j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, target, totSum, nums, dp);
    }

    private int solve(int i, int sum, int target, int totSum, int[] nums, int[][] dp) {
        // if (i >= nums.length) {
        //     return 0;
        // }

        if (i == nums.length) {

            if (sum == target) {
                return 1;
            }
            return 0;
        }

        if (dp[i][totSum + sum] != -1) {
            return dp[i][totSum + sum];
        }

        //System.out.println(sum);

        int add = solve(i + 1, sum + nums[i], target, totSum, nums, dp);
        int sub = solve(i + 1, sum - nums[i], target, totSum, nums, dp);

        return dp[i][totSum + sum] = add + sub;
    }
}
