class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        boolean[] used = new boolean[nums.length];

        for (int ele : nums) {
            sum += ele;
        }

        if (sum % k != 0) {
            return false;
        }

        return solve(0, 0, sum  / k, k, used, nums);
    }

    private boolean solve(int idx, int sum, int target, int k, boolean[] used, int[] nums) {
        
        if (k == 0) {
            return true;
        }

        if (target == sum) {
            return solve(0, 0, target, k - 1, used, nums);
        }

        for (int i = idx; i < nums.length; i++) {
            if (used[i] || nums[i] + sum > target) continue;

            used[i] = true;

            if (solve(i + 1, sum + nums[i], target, k, used, nums)) {
                return true;
            }

            used[i] = false;
        }

        return false;
        
    }
}