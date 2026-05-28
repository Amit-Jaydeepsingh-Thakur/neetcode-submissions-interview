class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int r = 0, l = 0, n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        while (r < n) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[r]) {
                dq.pollLast();
            }

            dq.addLast(r);

            if (l > dq.getFirst()) {
                dq.removeFirst();
            }

            if ((r + 1) >= k) {
                ans[l] = nums[dq.getFirst()];
                l++;
            }

            r++;
        }
        
        return ans;
    }
}
