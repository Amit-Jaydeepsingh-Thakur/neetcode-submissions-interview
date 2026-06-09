class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, end = nums.length - 1;

        while (mid <= end) {
            int key = nums[mid];

            if (key == 0) {
                swap(low, mid, nums);
                low++;
                //mid++;
            } else if (key == 2) {
                swap(mid, end, nums);
                end--;
                mid--;
            }

            mid++;
        }
    }

    private void swap(int l, int r, int[] nums) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}