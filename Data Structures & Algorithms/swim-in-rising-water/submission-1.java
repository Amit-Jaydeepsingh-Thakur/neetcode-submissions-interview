class Solution {
    public int swimInWater(int[][] grid) {
        int i = 0, j = 0, n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        boolean[][] vis = new boolean[n][n];
        pq.add(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int time = top[0];
            int u = top[1];
            int v = top[2];

            System.out.println(u + " " + v  + " " + time);

            if (u == n - 1 && v == n - 1) {
                return time;
            }

            for (int[] dir : dirs) {
                int x = u + dir[0];
                int y = v + dir[1];

                if (x >= 0 && y >= 0 && x < grid.length 
                    && y < grid[0].length
                    && !vis[x][y]) {
                    int t = Math.max(time, grid[x][y]);
                    pq.add(new int[]{t, x, y});
                    vis[x][y] = true;
                }
            }
            
            //time++;
        }

        return n * n;
        
    }
}
