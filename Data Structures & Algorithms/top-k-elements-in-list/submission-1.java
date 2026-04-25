class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int i = 0, j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (i = 0 ; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            freq[e.getValue()].add(e.getKey());
        }

        int[] res = new int[k];
        int idx = 0;

        for (i = freq.length - 1; i > 0 && idx < k; i--) {
            for (int n : freq[i]) {
                res[idx++] = n;
                if (idx == k) {
                    return res;
                }
            }            
        }

        return res;
        
    }
}
