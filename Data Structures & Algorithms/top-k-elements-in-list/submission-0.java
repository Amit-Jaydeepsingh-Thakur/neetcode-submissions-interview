class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int i = 0, j = 0;
        int[] ans = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        Map<Integer, Integer> map = new HashMap<>();

        for (int ele : nums) {
            if (!map.containsKey(ele)) {
                map.put(ele, 1);
            } else {
                map.put(ele, map.get(ele) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            pq.add(new int[]{val, key});
        }

        while (!pq.isEmpty() && k > 0) {
            int[] top = pq.poll();
            //System.out.println(top[1] + " " + top[0] + " " + k + " " + j);
            ans[j] = top[1];
            j++;
            k--;
        }

        return ans;
    }
}
