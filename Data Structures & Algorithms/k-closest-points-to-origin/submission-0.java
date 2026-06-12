class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int i = 0, j = 0;
        int[][] ans = new int[k][2];
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(a[0], b[0]));

        for (int[] point : points) {
            double dist = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            pq.add(new double[]{dist, (double)point[0], (double)point[1]});
        }

        while (!pq.isEmpty() && k > 0) {
            double[] top = pq.poll();
            ans[j][0] = (int)top[1];
            ans[j][1] = (int)top[2];

            j++;
            k--;
        }

        return ans;
    }
}
