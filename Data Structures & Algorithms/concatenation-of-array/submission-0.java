class Solution {
    public int[] getConcatenation(int[] nums) {
        int j = 0;
        int[] res = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            res[j++] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            res[j++] = nums[i];
        }

        return res;
    }
}