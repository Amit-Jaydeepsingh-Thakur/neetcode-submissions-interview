class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int j = 0;
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        for (Integer e : nums) {
            if (!map.containsKey(e)) {
                map.put(e, 1);
            } else {
                map.put(e, map.get(e) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int key = e.getKey();
            int value = e.getValue();

            pq.add(new int[]{value, key});
        }

        while (!pq.isEmpty() && k > 0) {
            int[] top = pq.poll();
            ans[j++] = top[1];
            k--;
        }

        return ans;
        
    }
}
