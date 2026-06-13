class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        solve(0, target, nums, tmp, ans);

        return ans;
    }

    private void solve(int idx, int target, int[] nums, List<Integer> tmp, List<List<Integer>> ans) {

        if (target == 0 && !ans.contains(tmp)) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        if (idx >= nums.length || target < 0) {
            return;
        }

        tmp.add(nums[idx]);
        
        solve(idx, target - nums[idx], nums, tmp, ans);
        solve(idx + 1, target - nums[idx], nums, tmp, ans);
        
        tmp.remove(tmp.size() - 1);
        solve(idx + 1, target, nums, tmp, ans);
    }
}
