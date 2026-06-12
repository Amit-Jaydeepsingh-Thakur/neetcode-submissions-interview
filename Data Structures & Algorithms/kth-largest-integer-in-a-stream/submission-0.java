class KthLargest {
    PriorityQueue<Integer> pq;
    int size = 0;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        size = k;
        for (int ele : nums) {
            pq.add(ele);

            if (pq.size() > k) {
                while (pq.size() > k) {
                    pq.poll();
                }
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);

        if (pq.size() > size) {
            while (pq.size() > size) {
                pq.poll();
            }
        } 

        return pq.peek();
    }
}
