class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        solve(0, nums, temp, ans);

        return ans;
    }

    private void solve(int idx, int[] nums, List<Integer> tmp, List<List<Integer>> ans) {
        if (!ans.contains(tmp)) {
            ans.add(new ArrayList<>(tmp));
        }

        if (idx >= nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            solve(i + 1, nums, tmp, ans);
            tmp.remove(tmp.size() - 1);
        }
    }
}
