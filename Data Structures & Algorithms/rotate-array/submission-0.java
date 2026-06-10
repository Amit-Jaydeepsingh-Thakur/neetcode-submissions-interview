class Solution {
    public void rotate(int[] nums, int k) {
        int i = 0, j = 0;
        int[] ans = new int[nums.length];
        k = k % nums.length;

        for (i = nums.length - k; i < nums.length; i++) {
            ans[j++] = nums[i];
        }

        for (i = 0; i <= nums.length - k - 1; i++) {
            ans[j++] = nums[i];
        }

        for (i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
        
    }
}