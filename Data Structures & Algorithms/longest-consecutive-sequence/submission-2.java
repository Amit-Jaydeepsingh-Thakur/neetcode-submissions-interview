class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int len = 1, start = 0, max = Integer.MIN_VALUE;
        Arrays.sort(nums);

        start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == start) continue;
            if (nums[i] - start == 1) {
                len++;
                max = Math.max(len, max);
            } else {
                len = 1;
            }

            start = nums[i];
        }

        return Math.max(max, len);
        
    }
}

// 0 1 1 2 3 4 5 6
