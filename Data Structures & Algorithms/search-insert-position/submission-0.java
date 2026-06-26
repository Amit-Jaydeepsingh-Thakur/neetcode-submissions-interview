class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, mid = 0, flag = 0, right = nums.length - 1;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                flag = 1;
                left = mid + 1;
            } else {
                flag = 2;
                right = mid - 1;
            }
        }

        return (flag == 1) ? mid + 1 : mid;
        
    }
}