class Solution {
    public String stoneGameIII(int[] nums) {
        int i = 0, j = 0;
        int[] dp = new int[nums.length + 1];

        Arrays.fill(dp, Integer.MIN_VALUE);

        int diff = solve(0, dp, nums);

        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private int solve(int idx, int[] dp, int[] nums) {
        if (idx >= nums.length) {
            return 0;
        }

        if (dp[idx] != Integer.MIN_VALUE) {
            return dp[idx];
        } 

        int diff = Integer.MIN_VALUE , w = 0;
        for (int i = idx; i < Math.min(idx + 3, nums.length); i++) {
            w += nums[i];
            diff = Math.max(diff, w - solve(i + 1, dp, nums));
        }

        return dp[idx] = diff;
    }
}