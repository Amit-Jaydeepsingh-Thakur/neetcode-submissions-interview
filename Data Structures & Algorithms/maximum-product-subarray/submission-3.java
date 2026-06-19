class Solution {
    public int maxProduct(int[] nums) {
        int i = 0, j = 0, ans = 0, max = Integer.MIN_VALUE;

        for (i = 0; i < nums.length; i++) {
            ans = nums[i];
            max = Math.max(max, ans);
            for (j = i + 1; j < nums.length; j++) {
                ans *= nums[j];
                max = Math.max(max, ans);
            }
        }

        return (max == Integer.MIN_VALUE) ? nums[0] : max;  
    }
}
