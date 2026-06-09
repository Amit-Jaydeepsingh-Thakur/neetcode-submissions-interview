class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> mem = new HashSet<>();

        for (Integer e : nums) {
            if(!mem.contains(e)) {
                mem.add(e);
            } else {
                return true;
            }
        }

        return false; 
    }
}