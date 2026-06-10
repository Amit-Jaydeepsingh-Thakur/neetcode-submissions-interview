class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0, r = 0, j = 0;
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        while (r < nums.length) {

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.pollLast();
            }

            dq.addLast(r);

            if (l > dq.getFirst()) {
                dq.removeFirst();
            }

            if (r - l + 1 == k) {
                ans[j++] = nums[dq.getFirst()];
                l++;
            }

            r++;

        }

        return ans;
        
    }
}
