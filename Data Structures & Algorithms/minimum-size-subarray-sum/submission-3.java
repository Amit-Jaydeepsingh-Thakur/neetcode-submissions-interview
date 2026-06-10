class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, res = Integer.MAX_VALUE, sum = 0;

        for (r = 0; r < nums.length; r++) {
            sum += nums[r];

            if (sum >= target) {
                while (sum >= target && l <= r) {
                    sum -= nums[l];
                    l++;
                }
                res = Math.min(res, Math.abs(r - (l - 1)) + 1);
            } 
        }

        return (res == Integer.MAX_VALUE) ? 0 : res;
        
    }
}