class Solution {
    public int combinationSum4(int[] nums, int target) {
        int i = 0, j = 0;
        int[] dp = new int[target + 1];

        Arrays.fill(dp, -1);

        return solve(target, nums, dp);

        // return ans.size();
    }

    private int solve(int target, int[] nums, int[] dp) {
        
        if (target < 0) {
            return 0 ;
        }

        if (target == 0) {
            //System.out.println(list.toString());
            return 1;
            //return;
        }

        if (dp[target]!= -1) {
            return dp[target];
        }

        int count = 0;
        for (int num : nums) {

            //if (target - nums[i] >= 0) {
                //list.add(nums[i]);
                count += solve(target - num, nums, dp);
                //list.remove(list.size() - 1);
            //}
        }

        return dp[target] = count;
    }
}