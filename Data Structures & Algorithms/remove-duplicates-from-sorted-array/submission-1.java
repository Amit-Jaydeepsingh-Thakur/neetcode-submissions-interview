class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0, l = 0, dup = 0;
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        k = set.size();

        for (int e : set) {
            nums[l++] = e;
        }

        return k;
        
    }
}