class Solution {
    public boolean hasDuplicate(int[] nums) {
        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();

        for (Integer ele : nums) {
            if (!set.contains(ele)) {
                set.add(ele);
            } else {
                return true;
            }
        }

        return false;
        
    }
}