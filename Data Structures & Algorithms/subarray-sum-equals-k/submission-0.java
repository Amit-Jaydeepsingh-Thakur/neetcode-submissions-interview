class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = 0, i = 0, j = 0, sum = 0, max = Integer.MIN_VALUE;

        for (i = 0; i < nums.length; i++) {
            sum = 0;
            for (j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    len++;
                }
            }

            max = Math.max(max, len);
        }

        return max;
    }
}