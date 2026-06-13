class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(0, nums, list, ans);

        return ans;
    }

    private void solve(int idx, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        
        ans.add(new ArrayList<>(list));
        
        if (idx >= nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            solve(i + 1, nums, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
