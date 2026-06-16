class Solution {
    public int minimumEffortPath(int[][] heights) {
        int i = 0, j = 0, n = heights.length, m = heights[0].length;
        int[][] dist = new int[n][m];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        } 

        dist[0][0] = 0;

        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int r = top[0];
            int c = top[1];
            int weight = top[2];

            if (r == n - 1 && c == m - 1) {
                return dist[r][c];
            }

            for (int[] dir : dirs) {
                int x = r + dir[0];
                int y = c + dir[1];

                if (x >= 0 && y >= 0 && x < n && y < m) {
                    int diff = Math.abs(heights[r][c] - heights[x][y]);
                    int newDiff = Math.max(weight, diff);

                    if (newDiff < dist[x][y]) {
                        dist[x][y] = newDiff;
                        pq.add(new int[]{x, y, dist[x][y]});
                    }
                }
            }
        }

        return 0;
    }
}