class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[][] dp = new int[nums.length][nums.length + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        //Arrays.fill(dp, Integer.MIN_VALUE);

        return solve(0, -1, dp, nums);
        
    }

    private int solve(int idx, int prevIdx, int[][] dp, int[] nums) {

        if (idx == nums.length) {
            return 0;
        }

        // if (idx == nums.length - 1 && nums[idx] > nums[prevIdx + 1]) {
        //     return 1;
        // }

        if (dp[idx][prevIdx + 1] != -1) {
            return dp[idx][prevIdx + 1];
        }

        int take = 0, notTake = 0;

        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            take = 1 + solve(idx + 1, idx, dp, nums);
        }

        notTake = solve(idx + 1, prevIdx, dp, nums);

        return dp[idx][prevIdx + 1] = Math.max(take, notTake);
    }
}
