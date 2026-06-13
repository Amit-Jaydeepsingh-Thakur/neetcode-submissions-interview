class Solution {
    public int findKthLargest(int[] nums, int k) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        for (int ele : nums) {
            pq.add(ele);
        }

        while (!pq.isEmpty() && k > 0) {
            ans = pq.poll();
            k--;
        }

        return ans;
        
    }
}
