class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(a -> a[0])));

        int pass = 0;

        for (int[] trip : trips) {
            int curr = trip[0];
            int start = trip[1];
            int end = trip[2];

            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                pass -= pq.poll()[1];
            }

            pass += curr;

            if (pass > capacity) {
                return false;
            }

            pq.offer(new int[]{end, curr});
        }

        return true;
    }
}