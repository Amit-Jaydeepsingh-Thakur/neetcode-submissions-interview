class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = 0;
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put((target - nums[i]), i);
            } else {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
                return ans;
            }
        }

        return ans;
        
    }
}
